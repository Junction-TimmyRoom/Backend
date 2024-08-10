package site.timmyroom.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import site.timmyroom.backend.config.ChatGPTConfig;
import site.timmyroom.backend.dto.request.AskRequestDTO;
import site.timmyroom.backend.dto.request.ChatCompletionDTO;
import site.timmyroom.backend.dto.response.ChatResponseDTO;
import site.timmyroom.backend.dto.response.Choice;
import site.timmyroom.backend.dto.response.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatGPTService {

    private final ChatGPTConfig chatGPTConfig;
    private final ObjectMapper mapper;
    private final RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.prompt}")
    private String promptUrl;

    public List<Choice> prompt(AskRequestDTO askRequestDTO) {
        Map<String, Object> resultMap = new HashMap<>();

        List<String> reviews = askRequestDTO.getReviews();
        String joinedReview = reviews.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        HttpHeaders headers = chatGPTConfig.httpHeaders();
        ChatCompletionDTO chatCompletionDTO = ChatCompletionDTO.builder()
                .model(model)
                .messages(List.of(
                        new Message("system", "You are an AI assistant that helps to summarize user-generated comments about various menus. Your goal is to create concise, informative, and helpful summaries that highlight the key points, nutritional information, potential benefits, or concerns related to each menu item, especially from the perspective of pregnant women. Focus on extracting actionable insights and advice that would be most beneficial for expecting mothers."),
                        new Message("user", joinedReview)
                        )
                ).build();

        HttpEntity<ChatCompletionDTO> requestEntity = new HttpEntity<>(chatCompletionDTO, headers);
        ResponseEntity<ChatResponseDTO> response = restTemplate.exchange(
                promptUrl,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<ChatResponseDTO>(){}
        );

        ChatResponseDTO contents = response.getBody();
        List<Choice> choices = contents.getChoices();

        return choices;
    }
}
