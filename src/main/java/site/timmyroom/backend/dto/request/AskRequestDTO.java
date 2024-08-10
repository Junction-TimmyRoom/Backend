package site.timmyroom.backend.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class AskRequestDTO {
    private List<String> reviews;
}
