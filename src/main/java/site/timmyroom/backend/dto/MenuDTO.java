package site.timmyroom.backend.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.*;

import java.util.List;

@Data
@Builder
public class MenuDTO {

    private Long id;
    private String name;
    private String contenet;
    private Integer recommendedServingSize;
    private Integer caloriesPer100gServing;
//    private List<ReviewDTO> reviews;
//    private List<ImageDTO> images;
//    private List<IngredientDTO> ingredients;
//    private MenuNutritionalFactDTO menuNutritionalFact;
//    private CategoryDTO category;
}
