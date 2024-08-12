package site.timmyroom.backend.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.Menu;

@Data
@Builder
public class MenuNutritionalFactDTO {

    private Long id;
    private Integer carbohydrates;
    private Integer sugars;
    private Integer protein;
    private Integer fat;
    private Integer saturatedFat;
    private Integer transFat;
    private Integer cholesterol;
    private Integer fiber;
    private Integer folicAcid;
    private Integer iron;
    private Integer calcium;
    private Integer omega3FattyAcid;
    private Integer vitaminB6;
    private Integer vitaminB12;
    private Integer vitaminC;
    private Integer vitaminD;
    private Integer magnesium;

}
