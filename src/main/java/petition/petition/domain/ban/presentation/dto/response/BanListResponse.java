package petition.petition.domain.ban.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import petition.petition.domain.ban.domain.Ban;
import petition.petition.domain.user.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class BanListResponse {

    private Long id;

    private String userName;

    private Long userId;

    private String bannedBy;

    private String banReason;

    private LocalDate bannedTime;

    public BanListResponse(Ban ban) {
        id = ban.getId();
        userName = ban.getUser().getUserName();
        userId = ban.getUser().getId();
        bannedBy = ban.getBannedBy();
        banReason = ban.getBanReason();
        bannedTime = ban.getBannedTime();
    }

}