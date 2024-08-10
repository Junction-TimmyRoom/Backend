package site.timmyroom.backend.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import site.timmyroom.backend.dto.ReviewDTO;
import site.timmyroom.backend.dto.request.MuseumLikeRequestDTO;
import site.timmyroom.backend.service.ReviewService;
import site.timmyroom.backend.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "유저")
public class UserController {

    private final UserService userService;
    private final ReviewService reviewService;

    // 유저아이디로 리뷰 아이디, 리뷰 내용, 리뷰 생성날짜 가져오는 api
    @PostMapping("/review")
    public ResponseEntity<List<ReviewDTO>> getReviews(@RequestParam String userId) {
        return ResponseEntity.ok(userService.getReviews(userId));
    }

}
