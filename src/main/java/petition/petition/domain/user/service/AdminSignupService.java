package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.domain.type.Role;
import petition.petition.domain.user.exception.CodeMisMatchException;
import petition.petition.domain.user.exception.UserAlreadyExistException;
import petition.petition.domain.user.presentation.dto.request.AdminSignupRequest;


@Service
@RequiredArgsConstructor
public class AdminSignupService {

    private final UserRepository userRepository;

    @Transactional
    public void signUp(AdminSignupRequest request) {

        if (userRepository.existsByAccountId(request.getUserEmail())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        if (!request.getCode().equals("daemago")) {
            throw CodeMisMatchException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .userName(request.getUserName())
                        .accountId(request.getAccountId())
                        .userEmail(request.getUserEmail())
                        .password(request.getPassword())
                        .role(Role.ADMIN)
                        .build()
        );
    }
}

