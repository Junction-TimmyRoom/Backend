package site.timmyroom.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.timmyroom.backend.dto.IngredientIngredientCharacteristicDTO;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientIngredientCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_characteristic_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private IngredientCharacteristic ingredientCharacteristic;

    public IngredientIngredientCharacteristicDTO toDTO(){
        return IngredientIngredientCharacteristicDTO .builder()
                .id(id)
                .ingredient(ingredient.toDTO())
                .ingredientCharacteristic(ingredientCharacteristic.toDTO())
                .build();
    }
}
