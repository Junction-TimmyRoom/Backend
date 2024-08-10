package site.timmyroom.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.dto.MenuDTO;
import site.timmyroom.backend.dto.ReviewDTO;

import java.util.List;

@Data
@Builder
public class MenuWithReviewsResponseDTO {

    private List<String> reviewSummaries;
    private List<ReviewDTO> reviews;
}
