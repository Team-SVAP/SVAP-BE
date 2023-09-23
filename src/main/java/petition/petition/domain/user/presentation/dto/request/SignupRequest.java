package petition.petition.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    @NotBlank(message = "이름을 입력하세요")
    private String userName;

    @NotNull(message = "아이디을 입력하세요")
    private String accountId;

    @NotBlank(message = "이메일을 입력하세요")
    private String userEmail;

    @NotNull(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    private String password;

}
