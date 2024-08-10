package site.timmyroom.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import site.timmyroom.backend.dto.response.MenuWithCategoryResponseDTO;
import site.timmyroom.backend.dto.response.MenuWithNutrionalFactResponseDTO;
import site.timmyroom.backend.dto.response.MenuWithReviewsResponseDTO;
import site.timmyroom.backend.service.MenuService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/menu/upload")
    public ResponseEntity<?> checkMenu(MultipartFile file){
        menuService.check(file);

        return null;
    }

    @GetMapping("/category/{menuId}")
    public ResponseEntity<MenuWithCategoryResponseDTO> getMenuWithCategory(@PathVariable("menuId") Long menuId){
        return ResponseEntity.ok(menuService.getMenuInfo(menuId));
    }

    @GetMapping("/nutritionFact/{menuId}")
    public ResponseEntity<MenuWithNutrionalFactResponseDTO> getMenuWithNutritionFact(@PathVariable("menuId") Long menuId){
        return ResponseEntity.ok(menuService.getMenuWithNutritionFact(menuId));
    }

    // 메뉴 아이디로 (해당 메뉴 아이디를 갖고 잇는 리뷰들의 요약본), 리뷰 내용, 리뷰 생성 날짜 반환하는 api
    @GetMapping("/reviews/{menuId}")
    public ResponseEntity<MenuWithReviewsResponseDTO> getMenuWithReviews(@PathVariable("menuId") Long menuId){
        return ResponseEntity.ok(menuService.getMenuWithReviews(menuId));
    }

    // 메뉴 아이디로 유저아이디, 리뷰아이디,리뷰 내용, 리뷰 생성날짜 반환하는 api

}
