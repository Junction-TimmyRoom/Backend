package site.timmyroom.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.timmyroom.backend.dto.ReviewDTO;
import site.timmyroom.backend.dto.UserDTO;
import site.timmyroom.backend.dto.request.ReviewCreateReqeusetDTO;
import site.timmyroom.backend.entity.Menu;
import site.timmyroom.backend.entity.Review;
import site.timmyroom.backend.entity.User;
import site.timmyroom.backend.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final MenuService menuService;

    // 유저아이디로 리뷰 아이디, 리뷰 내용, 리뷰 생성날짜 가져오는 api
    public List<ReviewDTO> getReviews(String nickname){
        List<Review> reviews = reviewRepository.findAllByUserNickname(nickname);
        return reviews.stream().map(review -> review.toDTO()).toList();
    }

    public Review createReview(String nickname, ReviewCreateReqeusetDTO request) {
        User user = userService.findUserById(nickname);
        Menu menu = menuService.findById(request.getMenuId());

        Review review = Review.builder()
                .content(request.getContent())
                .user(user)
                .menu(menu)
                .build();

        return reviewRepository.save(review);
    }
}
