package site.timmyroom.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.timmyroom.backend.dto.UserDTO;
import site.timmyroom.backend.entity.User;
import site.timmyroom.backend.excpetion.UserNotFoundException;
import site.timmyroom.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findUserByEmail(String email){
        return userRepository.findById(email).orElseThrow(() -> new UserNotFoundException());
    }

    public UserDTO findUserByIdDTO(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        return user.toDTO();
    }

    public User findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
    }
}
