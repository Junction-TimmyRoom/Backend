package site.timmyroom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.timmyroom.backend.dto.ReviewUserDTO;
import site.timmyroom.backend.entity.Ingredient;
import site.timmyroom.backend.entity.Menu;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT r, u FROM Review r JOIN r.user u JOIN r.menu m WHERE m.id = :menuId")
    List<Object[]> findReviewsAndUsersByMenuId(@Param("menuId") Long menuId);

    // 메뉴아이디로 갖고있는 영양성분 전부 조회하는 api
    @Query("SELECT m FROM Menu m " +
            "LEFT JOIN FETCH m.menuNutritionalFact " +
            "WHERE m.id = :menuId")
    Optional<Menu> findMenuWithMenuNutritionalFact(@Param("menuId") Long menuId);

    @Query("SELECT i FROM Ingredient i " +
            "LEFT JOIN FETCH i.ingredientCharacteristics " +
            "WHERE i.menu.id = :menuId")
    List<Ingredient> findIngredientsWithCharacteristicsByMenuId(@Param("menuId") Long menuId);

//    @Query("SELECT m FROM Category c " +
//            "LEFT JOIN FETCH c.menu m " +
//            "WHERE m.id = :menuId")
    @Query("SELECT m FROM Menu m LEFT JOIN FETCH m.category WHERE m.id = :menuId")
    Optional<Menu> findMenuWithCategory(Long menuId);
}
