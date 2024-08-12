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

    @OneToMany(mappedBy = "ingredient")
    private List<MenuIngredient> menuIngredients;

    @OneToMany(mappedBy = "ingredient")
    private List<IngredientCharacteristic> ingredientCharacteristics;

    public IngredientDTO toDTO(){
        return IngredientDTO.builder()
                .id(id)
                .name(name)
                .imgUrl(imgUrl)
                .ingredientCharacteristics(ingredientCharacteristics.stream().map(ingredientCharacteristic -> ingredientCharacteristic.toDTO()).toList())
                .build();
    }
}
