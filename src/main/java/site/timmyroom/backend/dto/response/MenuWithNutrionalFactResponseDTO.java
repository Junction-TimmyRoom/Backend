package site.timmyroom.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.dto.CategoryDTO;
import site.timmyroom.backend.dto.MenuDTO;
import site.timmyroom.backend.dto.MenuNutritionalFactDTO;
import site.timmyroom.backend.dto.PregnancyNutritionByMonthDTO;

@Data
@Builder
public class MenuWithNutrionalFactResponseDTO {

    private CategoryDTO category;
    private MenuDTO menu;
    private MenuNutritionalFactDTO nutritionalFact;
    private PregnancyNutritionByMonthDTO recommendedNutritionFact;
}
