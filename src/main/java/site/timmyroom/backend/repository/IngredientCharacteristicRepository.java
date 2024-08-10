package site.timmyroom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.timmyroom.backend.entity.IngredientCharacteristic;

@Repository
public interface IngredientCharacteristicRepository extends JpaRepository<IngredientCharacteristic, Long> {
}
