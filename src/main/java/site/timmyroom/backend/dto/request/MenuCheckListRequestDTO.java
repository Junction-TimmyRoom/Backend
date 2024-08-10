package site.timmyroom.backend.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class MenuCheckListRequestDTO {
    private List<String> menus;
}
