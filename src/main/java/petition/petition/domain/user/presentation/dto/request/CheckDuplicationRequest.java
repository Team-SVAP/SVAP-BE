package petition.petition.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class CheckDuplicationRequest {

    @Size(min = 5, max = 20, message = "아이디는 최소 5자, 최대 20자 입니다.")
    private String accountId;

}
