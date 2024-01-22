package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.AccountIdAlreadyExistsException;
import petition.petition.domain.user.presentation.dto.request.CheckAccountIdRequest;

@Service
@RequiredArgsConstructor
public class CheckAccountIdService {

    private final UserRepository userRepository;

    public void checkAccountId(CheckAccountIdRequest request) {


    }

}
