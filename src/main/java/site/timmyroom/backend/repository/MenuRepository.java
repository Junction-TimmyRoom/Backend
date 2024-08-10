package site.timmyroom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.timmyroom.backend.entity.Ingredient;
import site.timmyroom.backend.entity.Menu;
import site.timmyroom.backend.entity.Review;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT r FROM Review r JOIN r.user u JOIN r.menu m WHERE m.id = :menuId")
    List<Review> findReviewsAndUsersByMenuId(@Param("menuId") Long menuId);

    // 메뉴아이디로 갖고있는 영양성분 전부 조회하는 api
    @Query("SELECT m FROM Menu m " +
            "LEFT JOIN FETCH m.menuNutritionalFact " +
            "LEFT JOIN FETCH m.category " +
            "WHERE m.id = :menuId")
    Optional<Menu> findMenuWithMenuNutritionalFact(@Param("menuId") Long menuId);

    @Query("SELECT i FROM Ingredient i " +
            "LEFT JOIN FETCH i.ingredientCharacteristics " +
            "WHERE i.menu.id = :menuId")
    List<Ingredient> findIngredientsWithCharacteristicsByMenuId(@Param("menuId") Long menuId);

    @Query("SELECT m FROM Menu m LEFT JOIN FETCH m.category WHERE m.id = :menuId")
    Optional<Menu> findMenuWithCategory(Long menuId);

    // 메뉴 키워드 검색
    @Query("SELECT m " +
            "FROM Menu m " +
            "WHERE m.name LIKE %:keywork%")
    Optional<Menu> searchMenuByKeywork(@Param("keywork") String keywork);

    // 메뉴명으로 원재료, 원재료특징 조회
    @Query("SELECT i FROM Menu m " +
            "JOIN m.ingredients i " +
            "JOIN FETCH i.ingredientCharacteristics " +
            "WHERE m.id = :menuId ")
    List<Ingredient> findMenuByIdWithIngredients(@Param("menuId") Long menuId);

    Optional<Menu> findByName(String name);

    @Query("SELECT i FROM Ingredient i " +
            "JOIN FETCH i.ingredientCharacteristics ic " +
            "WHERE i.menu.id = :menuId")
    List<Ingredient> findIngredientsAndCharacteristicsByMenuId(@Param("menuId") Long menuId);

}
