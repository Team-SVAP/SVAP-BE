package petition.petition.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class UserWithdrawalService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void userWithdrawal() {
        User currentUser = userFacade.getCurrentUser();

        userRepository.deleteUserByAccountId(currentUser.getAccountId());
    }
}
