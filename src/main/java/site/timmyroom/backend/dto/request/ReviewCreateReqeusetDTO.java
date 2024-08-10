package site.timmyroom.backend.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewCreateReqeusetDTO {

    private String content;
    private Long menuId;

}
