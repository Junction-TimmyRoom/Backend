package site.timmyroom.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AskRequestDTO {
    private List<String> reviews;
}
