package site.timmyroom.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import site.timmyroom.backend.dto.UserDTO;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String email;

    @JsonIgnore
    private String password;
    private String name;

    @JsonIgnore
    private String role;

    public User update(String name){
        this.name = name;

        return this;
    }

    public UserDTO toDTO(){
        return UserDTO.builder()
                .email(email)
                .name(name)
                .build();
    }
}
