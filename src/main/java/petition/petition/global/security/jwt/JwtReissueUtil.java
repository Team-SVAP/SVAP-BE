package petition.petition.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.auth.RefreshToken;
import petition.petition.domain.auth.RefreshTokenRepository;
import petition.petition.global.exception.ExpiredTokenException;
import petition.petition.global.exception.InvalidTokenException;
import petition.petition.global.security.TokenResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class JwtReissueUtil {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final UserDetailsService userDetailsService;


    public TokenResponse reissue(String refreshToken) {

        if(isNotRefreshToken(refreshToken))
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

    private boolean isNotRefreshToken(String token) {
        Claims claims = getClaims(token);
        return claims == null || !claims.containsKey("type") || !"refresh".equals(claims.get("type"));
    }


    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token) {
        if (!isNotRefreshToken(token)) throw InvalidTokenException.EXCEPTION;
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    // 토큰에서 회원 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
