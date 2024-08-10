package site.timmyroom.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuDTO {

    private Long id;
    private String name;
    private String content;
    private Integer recommendedServingSize;
    private Integer caloriesPer100gServing;
    private String imgUrl;
//    private List<ReviewDTO> reviews;
//    private List<ImageDTO> images;
//    private List<IngredientDTO> ingredients;
//    private MenuNutritionalFactDTO menuNutritionalFact;
//    private CategoryDTO category;
}
