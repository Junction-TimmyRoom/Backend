package site.timmyroom.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String email;
    private String password;
    private String name;
}
