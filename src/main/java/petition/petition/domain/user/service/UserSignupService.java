package petition.petition.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.domain.type.Role;
import petition.petition.domain.user.facade.UserFacade;
import petition.petition.domain.user.presentation.dto.request.SignupRequest;
import petition.petition.global.security.TokenResponse;
import petition.petition.global.security.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;

    @Transactional
    public TokenResponse signUp(SignupRequest request) {

        userFacade.checkUserExists(request.getAccountId());

        String password = passwordEncoder.encode(request.getPassword());

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .userName(request.getUserName())
                        .password(password)
                        .role(Role.STUDENT)
                        .build()
        );

        return jwtTokenProvider.createToken(request.getAccountId());
    }

}
