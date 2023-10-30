package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.presentation.dto.response.MyInfoResponse;
import petition.petition.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class MyInfoService {

    private final UserFacade userFacade;

    public MyInfoResponse myInfo() {

        User currentUser = userFacade.getCurrentUser();

        MyInfoResponse response = MyInfoResponse.builder()
                .userName(currentUser.getUserName())
                .role(currentUser.getRole())
                .accountId(currentUser.getAccountId())
                .build();

        return response;
    }

}
