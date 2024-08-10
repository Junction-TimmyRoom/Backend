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

    public List<Review> findReviewsByUserId(String userId){
        return reviewRepository.findAllByUserEmail(userId);
    }
}
