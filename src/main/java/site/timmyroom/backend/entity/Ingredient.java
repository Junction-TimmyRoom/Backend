package site.timmyroom.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.timmyroom.backend.dto.IngredientDTO;
import site.timmyroom.backend.dto.MenuDTO;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private Menu menu;

    @OneToMany(mappedBy = "ingredient")
    @JsonIgnore
    private List<IngredientCharacteristic> ingredientCharacteristics;

    public IngredientDTO toDTO(){
        return IngredientDTO.builder()
                .id(id)
                .name(name)
                .imgUrl(imgUrl)
                .menu(menu.toDTO())
                .ingredientCharacteristics(ingredientCharacteristics.stream().map(ingredientCharacteristic -> ingredientCharacteristic.toDTO()).toList())
                .build();
    }
}
