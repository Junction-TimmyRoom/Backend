package site.timmyroom.backend.gloabl.auth;

import lombok.Getter;
import site.timmyroom.backend.entity.User;

@Getter
public class SessionUser {
    private String email;
    private String name;
    private String picture;

    public SessionUser(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
    }
}
