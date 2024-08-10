package site.timmyroom.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.timmyroom.backend.dto.ReviewDTO;
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
}
