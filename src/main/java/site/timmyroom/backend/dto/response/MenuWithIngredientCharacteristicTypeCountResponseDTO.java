package site.timmyroom.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.dto.MenuDTO;

@Data
@Builder
public class MenuWithIngredientCharacteristicTypeCountResponseDTO {

    private MenuDTO menu;
    private Integer countOfGood = 0;
    private Integer countOfCareful = 0;
    private Integer countOfEtc = 0;
}
