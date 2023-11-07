package petition.petition.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class CheckAccountIdRequest {

    @Size(min = 8, max = 30, message = "아이디는 최소 8자, 최대 30자 입니다.")
    private String accountId;

}
