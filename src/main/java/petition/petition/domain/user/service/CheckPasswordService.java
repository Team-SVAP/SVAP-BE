package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.presentation.dto.request.CheckPasswordRequest;
import petition.petition.domain.user.presentation.dto.request.CheckUsernameRequest;

@Service
@RequiredArgsConstructor
public class CheckPasswordService {

    public void checkPassword(CheckPasswordRequest request) {

    }
}
