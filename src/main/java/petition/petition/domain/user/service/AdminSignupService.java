package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.domain.type.Role;
import petition.petition.domain.user.exception.CodeMisMatchException;
import petition.petition.domain.user.exception.UserAlreadyExistException;
import petition.petition.domain.user.presentation.dto.request.AdminSignupRequest;
import petition.petition.global.security.TokenResponse;
import petition.petition.global.security.jwt.JwtTokenProvider;


@Service
@RequiredArgsConstructor
public class AdminSignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse signup(AdminSignupRequest request) {

        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        if (!request.getCode().equals("daemago")) {
            throw CodeMisMatchException.EXCEPTION;
        }

        String password = passwordEncoder.encode(request.getPassword());

        userRepository.save(
                User.builder()
                        .userName(request.getUserName())
                        .accountId(request.getAccountId())
                        .password(password)
                        .role(Role.ADMIN)
                        .build()
        );

        return jwtTokenProvider.createToken(request.getAccountId());
    }
}

