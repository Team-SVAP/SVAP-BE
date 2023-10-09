package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.UserNotFoundException;
import petition.petition.domain.user.presentation.dto.request.CheckDuplicationRequest;

@Service
@RequiredArgsConstructor
public class CheckDuplicationService {

    private final UserRepository userRepository;

    public void checkDuplication(CheckDuplicationRequest request) {

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

    }

}
