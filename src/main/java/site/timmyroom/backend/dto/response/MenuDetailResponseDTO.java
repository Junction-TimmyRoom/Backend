package site.timmyroom.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.Ingredient;
import site.timmyroom.backend.entity.MenuNutritionalFact;

import java.util.List;

@Data
@Builder
public class MenuDetailResponseDTO {

    private String categoryName;
    private String menuName;
    private String menuContent;

//    private
    private List<Ingredient> ingredients;
    private MenuNutritionalFact menuNutritionalFact;

}
