package site.timmyroom.backend.dto;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.Category;
import site.timmyroom.backend.entity.Review;

import java.util.List;

@Data
@Builder
public class MenuDTO {

    private Long id;
    private String name;
    private String content;
    private Integer recommendedServingSize;
    private Integer caloriesPer100gServing;
    private String imgUrl;

    private CategoryDTO category;
    private List<ReviewDTO> reviews;
    private MenuNutritionalFactDTO menuNutritionalFact;
    private List<IngredientDTO> ingredients;
}
