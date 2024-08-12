package site.timmyroom.backend.dto;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.IngredientIngredientCharacteristic;

@Data
@Builder
public class IngredientIngredientCharacteristicDTO {
    private Long id;

    private IngredientDTO ingredient;
    private IngredientCharacteristicDTO ingredientCharacteristic;
}
