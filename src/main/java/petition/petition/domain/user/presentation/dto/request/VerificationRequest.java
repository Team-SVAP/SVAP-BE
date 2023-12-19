package petition.petition.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class VerificationRequest {

    @Size(min = 8, max = 30, message = "아이디는 최소 8자, 최대 30자 입니다.")
    private String accountId;

    @Size(min = 2, max = 5, message = "이름은 최소 2자, 최대 5자 입니다.")
    private String username;

    @NotNull(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(
            regexp =
                    "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,32}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다.")
    private String password;

    public VerificationRequest(String accountId, String username, String password) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
    }

}
