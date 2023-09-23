package petition.petition.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LoginRequest {

    @NotBlank(message = "아이디 입력하세요")
    private String accountId;

    @NotBlank(message = "Email을 입력하세요")
    private String userEmail;

}
