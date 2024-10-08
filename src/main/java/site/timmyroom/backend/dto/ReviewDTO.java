package site.timmyroom.backend.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.Menu;
import site.timmyroom.backend.entity.Review;
import site.timmyroom.backend.entity.User;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewDTO {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private UserDTO user;
//    private MenuDTO menu;

    public ReviewDTO from(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .user(review.getUser().toDTO())
                .build();
    }
}
