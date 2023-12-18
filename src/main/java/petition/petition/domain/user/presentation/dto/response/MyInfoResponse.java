package petition.petition.domain.user.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.type.Role;

@RequiredArgsConstructor
@Getter
public class MyInfoResponse {

    private String userName;

    private Role role;

    private String accountId;

    private String test;//test

    public MyInfoResponse(User user) {
        userName = user.getUserName();
        role = user.getRole();
        accountId = user.getAccountId();
        test = user.getPassword();
    }
}
