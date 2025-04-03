package shop.mtcoding.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service

@Transactional
public class UserService {

    private final UserRepository userRepository;

    public void 회원가입(UserRequest.JoinDTO joinDTO) {
        userRepository.save(joinDTO.getUsername(), joinDTO.getPassword(), joinDTO.getEmail());
    }
}
