package petition.petition.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LoginRequest {

    @NotBlank(message = "아이디 입력하세요")
    @Size(min = 5, max = 15, message = "아이디는 최소 5자, 최대 15자 입니다.")
    private String accountId;

    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;

}
