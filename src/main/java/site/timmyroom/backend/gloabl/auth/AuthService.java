package site.timmyroom.backend.gloabl.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.timmyroom.backend.dto.request.LoginRequestDTO;
import site.timmyroom.backend.dto.request.SignupRequestDTO;
import site.timmyroom.backend.entity.User;
import site.timmyroom.backend.excpetion.UserAlreadyExistsException;
import site.timmyroom.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String login(LoginRequestDTO dto){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), "1111");
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtUtil.createAccessToken(authentication);
        return accessToken;
    }

    @Transactional
    public User signup(SignupRequestDTO request) {
        if(userRepository.existsById(request.getNickname()))
            throw new UserAlreadyExistsException();

        User user = User.builder()
                .password(passwordEncoder.encode("1111"))
                .nickname(request.getNickname())
                .pregnancyMonths(request.getPregnancyMonths())
                .role("ROLE_USER")
                .build();

        return userRepository.save(user);
    }
}
