package petition.petition.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CheckDuplicationRequest {

    private String accountId;

}
