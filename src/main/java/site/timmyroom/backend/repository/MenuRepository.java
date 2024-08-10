package site.timmyroom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.timmyroom.backend.entity.Ingredient;
import site.timmyroom.backend.entity.Menu;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT m FROM Menu m " +
            "LEFT JOIN m.reviews " +
            "LEFT JOIN m.menuNutritionalFact " +
            "LEFT JOIN m.category " +
            "WHERE m.id = :menuId")
    Menu findMenuWithReviewsAndNutritionalFactsAndCategory(@Param("menuId") Long menuId);

    @Query("SELECT i FROM Ingredient i " +
            "LEFT JOIN FETCH i.ingredientCharacteristics " +
            "WHERE i.menu.id = :menuId")
    List<Ingredient> findIngredientsWithCharacteristicsByMenuId(@Param("menuId") Long menuId);
}
