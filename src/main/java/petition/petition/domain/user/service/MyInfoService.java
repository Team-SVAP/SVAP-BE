package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.presentation.dto.response.MyInfoResponse;
import petition.petition.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyInfoService {

    private final UserFacade userFacade;

    public MyInfoResponse myInfo() {

        User currentUser = userFacade.getCurrentUser();

        return new MyInfoResponse(currentUser);

    }

}
