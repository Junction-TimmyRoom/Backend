package site.timmyroom.backend.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.Ingredient;
import site.timmyroom.backend.entity.IngredientCharacteristicType;

import java.util.List;

@Data
@Builder
public class IngredientCharacteristicDTO {

    private Long id;
    private IngredientCharacteristicType type;
    private String content;

    private List<IngredientIngredientCharacteristicDTO> ingredientIngredientCharacteristics;
}
