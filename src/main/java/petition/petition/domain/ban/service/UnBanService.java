package petition.petition.domain.ban.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.ban.domain.Ban;
import petition.petition.domain.ban.domain.repository.BanRepository;
import petition.petition.domain.ban.exception.BanNotFoundException;
import petition.petition.domain.user.service.facade.UserFacade;

@Service
@RequiredArgsConstructor
@Transactional
public class UnBanService {

    private final UserFacade userFacade;
    private final BanRepository banRepository;

    public void unBan(Long banId) {

        Ban ban = banRepository.findById(banId)
                .orElseThrow(() -> BanNotFoundException.EXCEPTION);

        banRepository.delete(ban);
    }
}
