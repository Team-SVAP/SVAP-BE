package petition.petition.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.global.security.TokenResponse;
import petition.petition.global.security.jwt.JwtReissueUtil;

@Service
@RequiredArgsConstructor
public class ReissueService {

    private final JwtReissueUtil jwtReissueUtil;

    @Transactional
    public TokenResponse reissue(String refreshToken) {
        return jwtReissueUtil.reissue(refreshToken);
    }

}
