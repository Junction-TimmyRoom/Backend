package site.timmyroom.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String nickname;
    private Integer pregnancyMonths;
}
