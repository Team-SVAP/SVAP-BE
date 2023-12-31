package petition.petition.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.ban.domain.repository.BanRepository;
import petition.petition.domain.petition.exception.PasswordMismatchException;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.BannedUserException;
import petition.petition.domain.user.exception.UserNotFoundException;
import petition.petition.domain.user.presentation.dto.request.LoginRequest;
import petition.petition.global.security.TokenResponse;
import petition.petition.global.security.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BanRepository banRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse login(LoginRequest request) {

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (banRepository.existsByUser(user)) {
            throw BannedUserException.EXCEPTION;
        }

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.createToken(user.getAccountId());
    }

}
