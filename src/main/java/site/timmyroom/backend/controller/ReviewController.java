package site.timmyroom.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import site.timmyroom.backend.dto.ReviewDTO;
import site.timmyroom.backend.dto.request.ReviewCreateReqeusetDTO;
import site.timmyroom.backend.entity.Review;
import site.timmyroom.backend.service.ReviewService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    // 유저아이디로 리뷰 아이디, 리뷰 내용, 리뷰 생성날짜 가져오는 api
    @GetMapping("/{nickname}")
    @Operation(summary = "유저의 리뷰 리스트를 제공한다.")
    public ResponseEntity<List<ReviewDTO>> getReviews(@PathVariable("nickname") String nickname) {
        return ResponseEntity.ok(reviewService.getReviews(nickname));
    }

    @PostMapping
    @Operation(summary = "리뷰를 생성한다.")
    public ResponseEntity<ReviewDTO> createReview(@AuthenticationPrincipal UserDetails userDetails, @RequestBody ReviewCreateReqeusetDTO request){
        Review review = reviewService.createReview(userDetails.getUsername(), request);

        return ResponseEntity.status(HttpStatus.CREATED).body(review.toDTO());
    }
}
