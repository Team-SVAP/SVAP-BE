package petition.petition.domain.ban.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.ban.domain.Ban;
import petition.petition.domain.ban.domain.repository.BanRepository;
import petition.petition.domain.ban.presentation.dto.request.BanRequest;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.UserNotFoundException;
import petition.petition.domain.user.service.facade.UserFacade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateBanUserService {

    private final BanRepository banRepository;
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public void createBan(String accountId, BanRequest request) {

        User currentUser = userFacade.getCurrentUser();

        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        LocalDate dateTime = LocalDate.now();

        banRepository.save(
                Ban.builder()
                        .user(user)
                        .bannedBy(currentUser.getUserName())
                        .banReason(request.getBanReason())
                        .bannedTime(dateTime)
                        .build()
        );
    }

}
