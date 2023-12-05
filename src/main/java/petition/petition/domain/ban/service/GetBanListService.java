package petition.petition.domain.ban.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.ban.domain.repository.BanRepository;
import petition.petition.domain.ban.presentation.dto.response.BanListResponse;
import petition.petition.domain.petition.exception.NotAdminException;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.facade.UserFacade;

import java.util.List;
import java.util.stream.Collectors;

import static petition.petition.domain.user.domain.type.Role.ADMIN;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetBanListService {

    private final BanRepository banRepository;
    private final UserFacade userFacade;

    public List<BanListResponse> getBan() {

        User currentUser = userFacade.getCurrentUser();

        if (currentUser.getRole() != ADMIN) {
            throw NotAdminException.EXCEPTION;
        }

        return banRepository.findAll()
                .stream()
                .map(BanListResponse::new)
                .toList();
    }

}
