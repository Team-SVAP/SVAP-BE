package petition.petition.global.security;

import lombok.Builder;
import lombok.Getter;
import petition.petition.domain.user.domain.type.Role;

@Getter
@Builder

public class TokenResponse {

    private String accessToken;

    //private String refreshToken;
}
