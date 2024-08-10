package site.timmyroom.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.dto.IngredientDTO;

import java.util.List;

@Data
@Builder
public class IngredientWithCharacteristicsResponseDTO {

    private List<IngredientDTO> ingredients;
}
