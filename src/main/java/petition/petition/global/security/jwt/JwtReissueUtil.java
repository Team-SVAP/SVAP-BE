package petition.petition.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.auth.RefreshToken;
import petition.petition.domain.auth.RefreshTokenRepository;
import petition.petition.global.exception.ExpiredTokenException;
import petition.petition.global.exception.InvalidTokenException;
import petition.petition.global.security.TokenResponse;
import petition.petition.global.security.auth.AuthDetailsService;


@Service
@RequiredArgsConstructor
@Transactional
public class JwtReissueUtil {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponse reissue(String refreshToken) {

        if(!isRefreshToken(refreshToken))
            throw InvalidTokenException.EXCEPTION;

        RefreshToken token = refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()->InvalidTokenException.EXCEPTION);

        String accountId = token.getAccountId();

        refreshTokenRepository.delete(token);

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(accountId))
                .refreshToken(refreshToken)
                .build();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private boolean isRefreshToken(String token) {
        return getClaims(token).get("type").equals("refresh");
    }

    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = authDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

}

