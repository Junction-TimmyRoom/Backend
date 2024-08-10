package site.timmyroom.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuNutritionalFact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * - 아이디(bigint, PK)
     * - 메뉴(bigint, FK)
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

    @OneToOne
    @JoinColumn(name = "menu_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private Menu menu;
}
