package site.timmyroom.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.timmyroom.backend.dto.*;
import site.timmyroom.backend.dto.response.MenuWithCategoryResponseDTO;
import site.timmyroom.backend.dto.response.MenuWithNutrionalFactResponseDTO;
import site.timmyroom.backend.dto.response.MenuWithReviewsResponseDTO;
import site.timmyroom.backend.entity.Menu;
import site.timmyroom.backend.entity.Review;
import site.timmyroom.backend.entity.User;
import site.timmyroom.backend.excpetion.MenuNotFound;
import site.timmyroom.backend.repository.MenuRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {
    private final MenuRepository menuRepository;

    public void check(MultipartFile file){
        // ChatGPT API 호출해서 메뉴명들 가져오기

        // DB에
    }

    @Transactional
    public MenuWithCategoryResponseDTO getMenuInfo(Long menuId) {
        Menu menu = menuRepository.findMenuWithCategory(menuId).orElseThrow(() -> new MenuNotFound());
        log.debug("메뉴랑 카테고리 같이 : {}", menu.toString());

        MenuWithCategoryResponseDTO menuWithCategoryResponseDTO = MenuWithCategoryResponseDTO.builder()
                .menu(MenuDTO.builder()
                        .id(menu.getId())
                        .name(menu.getName())
                        .contenet(menu.getContent())
                        .recommendedServingSize(menu.getRecommendedServingSize())
                        .caloriesPer100gServing(menu.getCaloriesPer100gServing())
                        .build()
                )
                .category(CategoryDTO.builder()
                        .id(menu.getCategory().getId())
                        .name(menu.getCategory().getName())
                        .build()
                ).build();

        return menuWithCategoryResponseDTO;
    }

    // 메뉴아이디로 갖고있는 영양성분 전부 조회하는 api
    @Transactional
    public MenuWithNutrionalFactResponseDTO getMenuWithNutritionFact(Long menuId) {
        Menu menu = menuRepository.findMenuWithMenuNutritionalFact(menuId).orElseThrow(() -> new MenuNotFound());

        MenuWithNutrionalFactResponseDTO response = MenuWithNutrionalFactResponseDTO.builder()
                .menu(MenuDTO.builder()
                        .id(menu.getId())
                        .name(menu.getName())
                        .contenet(menu.getContent())
                        .recommendedServingSize(menu.getRecommendedServingSize())
                        .caloriesPer100gServing(menu.getCaloriesPer100gServing())
                        .build()
                )
                .nutritionalFact(MenuNutritionalFactDTO.builder()
                    .id(menu.getMenuNutritionalFact().getId())
                    .carbohydrates(menu.getMenuNutritionalFact().getCarbohydrates())
                    .sugars(menu.getMenuNutritionalFact().getSugars())
                    .protein(menu.getMenuNutritionalFact().getProtein())
                    .fat(menu.getMenuNutritionalFact().getFat())
                    .saturatedFat(menu.getMenuNutritionalFact().getSaturatedFat())
                    .transFat(menu.getMenuNutritionalFact().getTransFat())
                    .cholesterol(menu.getMenuNutritionalFact().getCholesterol())
                    .fiber(menu.getMenuNutritionalFact().getFiber())
                    .folicAcid(menu.getMenuNutritionalFact().getFolicAcid())
                    .iron(menu.getMenuNutritionalFact().getIron())
                    .calcium(menu.getMenuNutritionalFact().getCalcium())
                    .omega3FattyAcid(menu.getMenuNutritionalFact().getOmega3FattyAcid())
                    .vitaminB6(menu.getMenuNutritionalFact().getVitaminB6())
                    .vitaminB12(menu.getMenuNutritionalFact().getVitaminB12())
                    .vitaminC(menu.getMenuNutritionalFact().getVitaminC())
                    .vitaminD(menu.getMenuNutritionalFact().getVitaminD())
                    .magnesium(menu.getMenuNutritionalFact().getMagnesium())
                    .build()
                ).build();

        return response;
    }

    // 메뉴 아이디로 (해당 메뉴 아이디를 갖고 잇는 리뷰들의 요약본), 리뷰 내용, 리뷰 생성 날짜 반환하는 api
    @Transactional
    public MenuWithReviewsResponseDTO getMenuWithReviews(Long menuId) {
        List<Object[]> results = menuRepository.findReviewsAndUsersByMenuId(menuId);

        MenuWithReviewsResponseDTO response = MenuWithReviewsResponseDTO.builder()
                .reviewSummary(null)
                .reviews(
                        results.stream().map(result -> {
                            Review review = (Review) result[0];
                            User user = (User) result[1];

                            return ReviewDTO.builder()
                                    .id(review.getId())
                                    .content(review.getContent())
                                    .createdAt(review.getCreatedAt())
                                    .user(UserDTO.builder()
                                            .nickname(user.getNickname())
                                            .pregnancyMonths(user.getPregnancyMonths())
                                            .build()
                                    )
                                    .build();
                        }).toList()
                ).build();

        return response;
    }
}
