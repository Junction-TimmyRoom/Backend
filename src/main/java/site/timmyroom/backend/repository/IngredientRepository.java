package site.timmyroom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.timmyroom.backend.entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
