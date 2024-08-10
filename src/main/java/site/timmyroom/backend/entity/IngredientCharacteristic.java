package site.timmyroom.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.timmyroom.backend.dto.IngredientCharacteristicDTO;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private IngredientCharacteristicType type;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private Ingredient ingredient;

    public IngredientCharacteristicDTO toDTO(){
        return IngredientCharacteristicDTO.builder()
                .id(id)
                .type(type)
                .content(content)
                .build();
    }
}
