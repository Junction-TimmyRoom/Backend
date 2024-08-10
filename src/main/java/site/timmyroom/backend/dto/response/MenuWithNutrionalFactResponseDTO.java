package site.timmyroom.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.dto.MenuDTO;
import site.timmyroom.backend.dto.MenuNutritionalFactDTO;

@Data
@Builder
public class MenuWithNutrionalFactResponseDTO {

    private MenuDTO menu;
    private MenuNutritionalFactDTO nutritionalFactDTO;
}
