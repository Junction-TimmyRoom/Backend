package site.timmyroom.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private String url;

    @OneToOne
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    private Menu menu;

    @OneToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Builder
    public Image(String id, String contentType, Long size, String url, Menu menu, Ingredient ingredient) {
        this.id = id;
        this.contentType = contentType;
        this.size = size;
        this.url = url;
        this.menu = menu;
        this.ingredient = ingredient;
    }
}
