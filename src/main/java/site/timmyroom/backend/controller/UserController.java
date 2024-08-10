package site.timmyroom.backend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.timmyroom.backend.dto.request.MuseumLikeRequestDTO;
import site.timmyroom.backend.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "유저")
public class UserController {

    private final UserService userService;

}
