package site.timmyroom.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Image {
    @Id
    private String id;
    private String contentType;
    private Long size;
    private String name;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    private Menu menu;

    @Builder
    public Image(String id, String contentType, Long size, String name, Menu menu) {
        this.id = id;
        this.contentType = contentType;
        this.size = size;
        this.name = name;
        this.menu = menu;
    }
}
