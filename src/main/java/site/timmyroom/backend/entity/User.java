package site.timmyroom.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import site.timmyroom.backend.dto.UserDTO;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String nickname;

    @JsonIgnore
    private String password;
    private Integer pregnancyMonths;

    @JsonIgnore
    private String role;

    public UserDTO toDTO(){
        return UserDTO.builder()
                .nickname(nickname)
                .pregnancyMonths(pregnancyMonths)
                .build();
    }
}
