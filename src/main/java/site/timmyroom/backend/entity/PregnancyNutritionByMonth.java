package site.timmyroom.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.timmyroom.backend.dto.PregnancyNutritionByMonthDTO;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PregnancyNutritionByMonth {

    @Id
    private Integer month;

    /**
     * - 탄수화물
     * - 당류
     * - 단백질
     * - 지방
     * - 포화지방
     * - 트랜스지방
     * - 콜레스테롤
     * - 섬유질
     * - 엽산
     * - 철분
     * - 칼슘
     * - 오메가3지방산
     * - 비타민B6
     * - 비타민B12
     * - 비타민C
     * - 비타민D
     * - 마그네슘
     */
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

    public PregnancyNutritionByMonthDTO toDTO(){
        return PregnancyNutritionByMonthDTO.builder()
                .month(month)
                .carbohydrates(carbohydrates)
                .sugars(sugars)
                .protein(protein)
                .fat(fat)
                .saturatedFat(saturatedFat)
                .transFat(transFat)
                .cholesterol(cholesterol)
                .fiber(fiber)
                .folicAcid(folicAcid)
                .iron(iron)
                .calcium(calcium)
                .omega3FattyAcid(omega3FattyAcid)
                .vitaminB6(vitaminB6)
                .vitaminB12(vitaminB12)
                .vitaminC(vitaminC)
                .vitaminD(vitaminD)
                .magnesium(magnesium)
                .build();
    }
}
