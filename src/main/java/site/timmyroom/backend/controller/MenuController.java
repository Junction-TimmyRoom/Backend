package site.timmyroom.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.timmyroom.backend.dto.request.MenuCheckListRequestDTO;
import site.timmyroom.backend.dto.response.MenuWithCategoryResponseDTO;
import site.timmyroom.backend.dto.response.MenuWithIngredientCharacteristicTypeCountResponseDTO;
import site.timmyroom.backend.dto.response.MenuWithNutrionalFactResponseDTO;
import site.timmyroom.backend.dto.response.MenuWithReviewsResponseDTO;
import site.timmyroom.backend.service.MenuService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
@Slf4j
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/check")
    @Operation(summary = "메뉴 리스트 제공 시 권고, 금지 개수를 제공한다.")
    public ResponseEntity<List<MenuWithIngredientCharacteristicTypeCountResponseDTO>> checkMenu(@RequestBody MenuCheckListRequestDTO menuCheckListRequestDTO){
        return ResponseEntity.ok(menuService.check(menuCheckListRequestDTO));
    }

    @GetMapping("/category/{menuId}")
    @Operation(summary = "메뉴 정보와 카테고리를 제공한다.")
    public ResponseEntity<MenuWithCategoryResponseDTO> getMenuWithCategory(@PathVariable("menuId") Long menuId){
        return ResponseEntity.ok(menuService.getMenuInfo(menuId));
    }

    @GetMapping("/nutritionFact/{menuId}")
    @Operation(summary = "메뉴 정보와 영양정보를 제공한다.")
    public ResponseEntity<MenuWithNutrionalFactResponseDTO> getMenuWithNutritionFact(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("menuId") Long menuId){
        return ResponseEntity.ok(menuService.getMenuWithNutritionFact(userDetails.getUsername(), menuId));
    }

    // 메뉴 아이디로 (해당 메뉴 아이디를 갖고 잇는 리뷰들의 요약본), 리뷰 내용, 리뷰 생성 날짜 반환하는 api
    @GetMapping("/review/{menuId}")
    @Operation(summary = "메뉴 정보와 리뷰 리스트를 제공한다.")
    public ResponseEntity<MenuWithReviewsResponseDTO> getMenuWithReviews(@PathVariable("menuId") Long menuId){
        return ResponseEntity.ok(menuService.getMenuWithReviews(menuId));
    }
}
