package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.AccountIdAlreadyExistsException;
import petition.petition.domain.user.presentation.dto.request.VerificationRequest;

@Service
@RequiredArgsConstructor
public class VerificationService {

    private final UserRepository userRepository;

    public void checkAccountId(VerificationRequest request) {

        if (request.getAccountId() != null) {
            if (userRepository.existsByAccountId(request.getAccountId())) {
                throw AccountIdAlreadyExistsException.EXCEPTION;
            }
        }
    }

}
