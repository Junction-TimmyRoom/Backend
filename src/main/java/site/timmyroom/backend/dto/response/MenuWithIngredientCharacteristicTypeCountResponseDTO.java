package site.timmyroom.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.dto.MenuDTO;

@Data
@Builder
public class MenuWithIngredientCharacteristicTypeCountResponseDTO {

    private MenuDTO menu;

    @Builder.Default
    private Integer countOfGood = 0;
    @Builder.Default
    private Integer countOfCareful = 0;
    @Builder.Default
    private Integer countOfEtc = 0;
}
