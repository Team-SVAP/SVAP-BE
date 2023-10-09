package petition.petition.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import petition.petition.domain.user.domain.type.Role;

@Builder
@Getter
public class MyInfoResponse {

    private String userName;

    private Role role;
}
