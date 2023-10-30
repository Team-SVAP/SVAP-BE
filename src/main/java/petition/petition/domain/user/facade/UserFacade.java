package petition.petition.domain.user.facade;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import petition.petition.domain.petition.exception.NotAdminException;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.CodeMisMatchException;
import petition.petition.domain.user.exception.UserAlreadyExistException;
import petition.petition.domain.user.exception.UserNotFoundException;

import static petition.petition.domain.user.domain.type.Role.ADMIN;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;
    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

    }

    public void checkUserExists(String accountId) {
        if (userRepository.findByAccountId(accountId).isPresent()) {
            throw UserAlreadyExistException.EXCEPTION;
        }
    }

    public void checkCodeCorrect(String code) {
        if (!code.equals("daemago")) {
            throw CodeMisMatchException.EXCEPTION;
        }
    }

    public void checkAdmin(User user) {
        if (user.getRole() != ADMIN) {
            throw NotAdminException.EXCEPTION;
        }
    }
}
