package petition.petition.domain.ban.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CreateBanRequest {

    @NotNull(message = "차단할 유저의 accountId를 입력해주세요.")
    private String accountId;

    @NotNull(message = "content은 null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 200, message = "content은 최대 200자까지 가능합니다.")
    private String banReason;

}
