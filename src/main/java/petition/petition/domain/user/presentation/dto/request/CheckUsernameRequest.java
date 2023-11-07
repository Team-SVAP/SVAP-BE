package petition.petition.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class CheckUsernameRequest {

    @Size(min = 2, max = 5, message = "이름은 최소 2자, 최대 5자 입니다.")
    private String username;

}
