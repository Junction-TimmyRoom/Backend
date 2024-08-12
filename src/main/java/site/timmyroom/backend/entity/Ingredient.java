package site.timmyroom.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.timmyroom.backend.dto.IngredientCharacteristicDTO;
import site.timmyroom.backend.dto.IngredientDTO;

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
    private List<IngredientIngredientCharacteristic> ingredientIngredientCharacteristics;

    public IngredientDTO toDTO(){
        List<IngredientCharacteristicDTO> characteristicDTOs = ingredientIngredientCharacteristics.stream()
                .map(iic -> iic.getIngredientCharacteristic().toDTO())
                .toList();

        return IngredientDTO.builder()
                .id(id)
                .name(name)
                .imgUrl(imgUrl)
                .ingredientCharacteristics(characteristicDTOs)
                .build();
    }
}
