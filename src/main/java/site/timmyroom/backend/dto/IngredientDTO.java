package site.timmyroom.backend.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.IngredientCharacteristic;
import site.timmyroom.backend.entity.Menu;

import java.util.List;

@Data
@Builder
public class IngredientDTO {

    private Long id;
    private String name;
    private MenuDTO menu;
    private List<IngredientCharacteristicDTO> ingredientCharacteristics;
}
