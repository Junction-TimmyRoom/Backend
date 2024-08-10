package site.timmyroom.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import site.timmyroom.backend.dto.ReviewDTO;
import site.timmyroom.backend.entity.Review;
import site.timmyroom.backend.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // 유저아이디로 리뷰 아이디, 리뷰 내용, 리뷰 생성날짜 가져오는 api
    public List<ReviewDTO> getReviews(String userId){
        List<Review> reviews = reviewRepository.findAllByUserEmail(userId);
        return reviews.stream().map(review -> review.toDTO()).toList();
    }
}
