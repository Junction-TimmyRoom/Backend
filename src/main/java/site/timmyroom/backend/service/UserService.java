package site.timmyroom.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.timmyroom.backend.dto.ReviewDTO;
import site.timmyroom.backend.entity.Review;
import site.timmyroom.backend.entity.User;
import site.timmyroom.backend.excpetion.UserNotFoundException;
import site.timmyroom.backend.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ReviewService reviewService;

    public User findUserByEmail(String email){
        return userRepository.findById(email).orElseThrow(() -> new UserNotFoundException());
    }

    // 유저아이디로 리뷰 아이디, 리뷰 내용, 리뷰 생성날짜 가져오는 api
    public List<ReviewDTO> getReviews(String userId){
        List<Review> reviews = reviewService.findReviewsByUserId(userId);
        return reviews.stream().map(review -> review.toDTO()).toList();
    }
}
