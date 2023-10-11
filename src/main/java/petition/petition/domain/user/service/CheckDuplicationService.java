package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.IdAlreadyExistsException;
import petition.petition.domain.user.presentation.dto.request.CheckDuplicationRequest;

@Service
@RequiredArgsConstructor
public class CheckDuplicationService {

    private final UserRepository userRepository;

    public void checkDuplication(CheckDuplicationRequest request) {

        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw IdAlreadyExistsException.EXCEPTION;
        }

    }

}
