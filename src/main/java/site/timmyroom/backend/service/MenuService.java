package site.timmyroom.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.timmyroom.backend.dto.MenuDTO;
import site.timmyroom.backend.dto.response.MenuWithCategoryResponseDTO;
import site.timmyroom.backend.entity.Ingredient;
import site.timmyroom.backend.entity.Menu;
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
        Menu menuWithReviewsAndNutritionalFacts = menuRepository.findMenuWithReviewsAndNutritionalFactsAndCategory(menuId);
        log.debug("메뉴랑 카테고리 같이 : {}", menuWithReviewsAndNutritionalFacts.toString());

//        MenuWithCategoryResponseDTO.builder()
//                .menu(MenuDTO.)
        return null;

    }
}
