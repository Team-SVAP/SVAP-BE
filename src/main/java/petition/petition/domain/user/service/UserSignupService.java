package petition.petition.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.domain.type.Role;
import petition.petition.domain.user.exception.UserAlreadyExistException;
import petition.petition.domain.user.presentation.dto.request.SignupRequest;
import petition.petition.global.security.TokenResponse;
import petition.petition.global.security.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse signUp(SignupRequest request) {

        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .userName(request.getUserName())
                        .password(request.getPassword())
                        .role(Role.STUDENT)
                        .build()
        );

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(request.getAccountId()))
                .build();
    }
}
