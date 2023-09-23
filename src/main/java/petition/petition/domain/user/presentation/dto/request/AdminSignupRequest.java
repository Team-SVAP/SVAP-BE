package petition.petition.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AdminSignupRequest {

    @NotBlank(message = "이름을 입력하세요")
    private String userName;

    @NotBlank(message = "이메일을 입력하세요")
    private String userEmail;

    @NotBlank(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(
            regexp =
                    "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,32}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다.")
    private String password;

    private String code;

    private String accountId;

}
