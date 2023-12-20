package petition.petition.domain.ban.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.ban.domain.repository.BanRepository;
import petition.petition.domain.ban.exception.BanNotFoundException;
import petition.petition.domain.petition.exception.NotAdminException;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.facade.UserFacade;

import static petition.petition.domain.user.domain.type.Role.ADMIN;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteBanService {

    private final UserFacade userFacade;
    private final BanRepository banRepository;

    public void deleteBan(Long banId) {

        User currentUser = userFacade.getCurrentUser();

        if (currentUser.getRole() != ADMIN) {
            throw NotAdminException.EXCEPTION;
        }

        banRepository.findById(banId)
                .orElseThrow(() -> BanNotFoundException.EXCEPTION);

        banRepository.deleteBanById(banId);
    }

}
