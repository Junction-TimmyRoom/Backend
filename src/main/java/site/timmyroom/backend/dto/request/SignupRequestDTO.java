package site.timmyroom.backend.dto.request;

import lombok.Data;

@Data
public class SignupRequestDTO {
    private String nickname;
    private Integer pregnancyMonths;
}
