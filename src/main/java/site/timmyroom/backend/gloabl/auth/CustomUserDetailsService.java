package site.timmyroom.backend.gloabl.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import site.timmyroom.backend.entity.User;
import site.timmyroom.backend.repository.UserRepository;

import java.util.List;

@Component("userDetailsService")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저가 없습니다."));

        return new org.springframework.security.core.userdetails.User(user.getNickname(), user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
