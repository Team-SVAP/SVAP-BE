package petition.petition.domain.user.service.facade;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.UserNotFoundException;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;
    public User getCurrentUser() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(userEmail)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

    }

}
