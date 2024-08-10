package site.timmyroom.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.timmyroom.backend.dto.*;
import site.timmyroom.backend.dto.request.AskRequestDTO;
import site.timmyroom.backend.dto.request.MenuCheckListRequestDTO;
import site.timmyroom.backend.dto.response.*;
import site.timmyroom.backend.entity.*;
import site.timmyroom.backend.excpetion.MenuNotFound;
import site.timmyroom.backend.repository.MenuRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {
    private final MenuRepository menuRepository;
    private final IngredientService ingredientService;
    private final UserService userService;
    private final ChatGPTService chatGPTService;

    @Transactional
    public List<MenuWithIngredientCharacteristicTypeCountResponseDTO> check(MenuCheckListRequestDTO menuCheckListRequestDTO){
        List<String> menuNames = menuCheckListRequestDTO.getMenus().stream()
                .map(String::toLowerCase)
                .map(menu -> menu.replaceAll(" ", ""))
                .toList();

        List<Menu> filteredMenus = new ArrayList<>();
        for (String menuName : menuNames) {
            Optional<Menu> menu = menuRepository.searchMenuByKeywork(menuName);
            menu.ifPresent(m -> filteredMenus.add(m));
        }


        // 메뉴명으로 메뉴 사진, 원재료 구분별로 개수
        List<MenuWithIngredientCharacteristicTypeCountResponseDTO> response = new ArrayList<>();
        for (Menu menu : filteredMenus) {
            List<Ingredient> ingredients = menuRepository.findMenuByIdWithIngredients(menu.getId());
            Integer countOfGood = 0;
            Integer countOfCareful = 0;
            Integer countOfEtc = 0;

            for (Ingredient ingredient : ingredients) {
                for (IngredientCharacteristic ingredientCharacteristic : ingredient.getIngredientCharacteristics()) {
                    if(ingredientCharacteristic.getType().equals(IngredientCharacteristicType.GOOD)) {
                        countOfGood++;
                    }
                    if(ingredientCharacteristic.getType().equals(IngredientCharacteristicType.CAREFUL)) {
                        countOfCareful++;
                    }
                    if(ingredientCharacteristic.getType().equals(IngredientCharacteristicType.ETC)) {
                        countOfEtc++;
                    }
                }
            }

            response.add(
                    MenuWithIngredientCharacteristicTypeCountResponseDTO.builder()
                    .menu(menu.toDTO())
                    .countOfGood(countOfGood)
                    .countOfCareful(countOfCareful)
                    .countOfEtc(countOfEtc)
                    .build()
            );
        }

        return response;
    }

    @Transactional
    public MenuWithCategoryResponseDTO getMenuInfo(Long menuId) {
        Menu menu = menuRepository.findMenuWithCategory(menuId).orElseThrow(() -> new MenuNotFound());
        log.debug("메뉴랑 카테고리 같이 : {}", menu.toString());

        MenuWithCategoryResponseDTO menuWithCategoryResponseDTO = MenuWithCategoryResponseDTO.builder()
//                .menu(MenuDTO.builder()
//                        .id(menu.getId())
//                        .name(menu.getName())
//                        .contenet(menu.getContent())
//                        .recommendedServingSize(menu.getRecommendedServingSize())
//                        .caloriesPer100gServing(menu.getCaloriesPer100gServing())
//                        .build()
//                )
                .menu(menu.toDTO())
                .category(CategoryDTO.builder()
                        .id(menu.getCategory().getId())
                        .name(menu.getCategory().getName())
                        .build()
                ).build();

        return menuWithCategoryResponseDTO;
    }

    // 메뉴아이디로 갖고있는 영양성분 전부 조회하는 api
    @Transactional
    public MenuWithNutrionalFactResponseDTO getMenuWithNutritionFact(String nickname, Long menuId) {
        PregnancyNutritionByMonth recommenedNutritionByMonth = userService.findRecommenedNutritionByMonth(nickname);
        Menu menu = menuRepository.findMenuWithMenuNutritionalFact(menuId).orElseThrow(() -> new MenuNotFound());

        MenuWithNutrionalFactResponseDTO response = MenuWithNutrionalFactResponseDTO.builder()
                .category(menu.getCategory().toDTO())
                .menu(menu.toDTO())
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
                )
                .recommendedNutritionFact(recommenedNutritionByMonth.toDTO())
                .build();

        return response;
    }

    // 메뉴 아이디로 (해당 메뉴 아이디를 갖고 잇는 리뷰들의 요약본), 리뷰 내용, 리뷰 생성 날짜 반환하는 api
    @Transactional
    public MenuWithReviewsResponseDTO getMenuWithReviews(Long menuId) {
        List<Review> reviews = menuRepository.findReviewsAndUsersByMenuId(menuId);
        List<Choice> choices = chatGPTService.prompt(new AskRequestDTO(
                reviews.stream()
                        .map(review -> review.getContent())
                        .toList()
        ));

        List<String> messages = new ArrayList<>();
        for (Choice choice : choices) {
            String content = choice.getMessage().getContent();
            messages.addAll(splitMessage(content));
        }

        if(messages.size() > 2){
            messages = messages.subList(0, 2);
        }

        MenuWithReviewsResponseDTO response = MenuWithReviewsResponseDTO.builder()
                .reviewSummaries(messages)
                .reviews(reviews.stream().map(review -> review.toDTO()).toList())
                .build();

        return response;
    }

    private List<String> splitMessage(String message){
        List<String> split = List.of(message.split("-"));
        return split.stream()
                .filter( str -> str != null && !str.trim().isEmpty())
                .map(str -> str.trim())
                .map(str -> str.replaceAll("^\\n", ""))
                .toList();
    }

    public Menu findById(Long menuId) {
        return menuRepository.findById(menuId).orElseThrow(() -> new MenuNotFound());
    }

    public Menu getMenuIdByName(String menuName) {
        Menu menu = menuRepository.findByName(menuName).orElseThrow(() -> new MenuNotFound());
        return menu;
    }

    public List<IngredientDTO> getIngredients(Long menuId) {
        List<Ingredient> ingredients = menuRepository.findIngredientsAndCharacteristicsByMenuId(menuId);

        return ingredients.stream().map(ingredient -> ingredient.toDTO()).toList();
    }
}
