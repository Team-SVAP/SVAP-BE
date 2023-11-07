package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.AccountIdAlreadyExistsException;
import petition.petition.domain.user.presentation.dto.request.CheckUsernameRequest;

@Service
@RequiredArgsConstructor
public class CheckUsernameService {

    private final UserRepository userRepository;

    public void checkUsername(CheckUsernameRequest request) {

        if (userRepository.existsByAccountId(request.getUsername())) {
            throw AccountIdAlreadyExistsException.EXCEPTION;
        }

    }
}
