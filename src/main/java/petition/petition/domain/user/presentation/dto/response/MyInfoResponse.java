package petition.petition.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import petition.petition.domain.user.domain.type.Role;

import javax.persistence.Access;

@Builder
@Getter
public class MyInfoResponse {

    private String userName;

    private Role role;
}
