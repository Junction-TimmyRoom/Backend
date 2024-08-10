package site.timmyroom.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.dto.CategoryDTO;
import site.timmyroom.backend.dto.MenuDTO;

// 메뉴 아이디로 카테고리, 이름,내용,1회권장섭취량,100g당칼로리 가져오는 api
@Data
@Builder
public class MenuWithCategoryResponseDTO {

    private CategoryDTO category;
    private MenuDTO menu;
}
