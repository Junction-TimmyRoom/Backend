package site.timmyroom.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.timmyroom.backend.dto.request.AskRequestDTO;
import site.timmyroom.backend.dto.response.Choice;
import site.timmyroom.backend.service.ChatGPTService;

import java.util.List;

@RestController
@RequestMapping("/chatGpt")
@RequiredArgsConstructor
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    @PostMapping("/prompt")
    public ResponseEntity<List<Choice>> selectPrompt(@RequestBody AskRequestDTO askRequestDTO){
        List<Choice> result = chatGPTService.prompt(askRequestDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
