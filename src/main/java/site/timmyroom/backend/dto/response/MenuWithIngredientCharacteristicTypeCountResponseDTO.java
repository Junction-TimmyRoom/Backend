package site.timmyroom.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.dto.MenuDTO;

@Data
@Builder
public class MenuWithIngredientCharacteristicTypeCountResponseDTO {

    private MenuDTO menu;
    private Integer countOfAdvisor = 0;
    private Integer countOfProhibited = 0;
}
