package site.timmyroom.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.timmyroom.backend.dto.MenuDTO;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String content;
    private Integer recommendedServingSize;
    private Integer caloriesPer100gServing;

    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    private List<Review> reviews;

    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    private List<Image> images;

    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    private List<Ingredient> ingredients;

    @OneToOne(mappedBy = "menu")
    @JsonIgnore
    private MenuNutritionalFact menuNutritionalFact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private Category category;

    public MenuDTO toDTO(){
        return MenuDTO.builder()
                .id(id)
                .name(name)
                .contenet(content)
                .recommendedServingSize(recommendedServingSize)
                .caloriesPer100gServing(caloriesPer100gServing)
                .build();
    }
}
