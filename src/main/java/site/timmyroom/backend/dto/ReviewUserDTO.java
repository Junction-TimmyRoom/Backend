package site.timmyroom.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.Review;
import site.timmyroom.backend.entity.User;

@Data
@Builder
@AllArgsConstructor
public class ReviewUserDTO {
    private Review review;
    private User user;

    public ReviewDTO reviewDTO(){
        return ReviewDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .user(review.getUser().toDTO())
                .build();
    }
}