package site.timmyroom.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import site.timmyroom.backend.dto.UserDTO;
import site.timmyroom.backend.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
@Tag(name = "유저")
public class UserController {

    private final UserService userService;

    // 토큰으로 유저 닉네임, 임신 날짜 가져오는 api
    @GetMapping
    @Operation(summary = " 유저 정보를 제공한다.")
    public ResponseEntity<UserDTO> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(userService.findUserByIdDTO(userDetails.getUsername()));
    }


}
