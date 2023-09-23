package petition.petition.domain.ban.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import petition.petition.domain.ban.domain.Ban;
import petition.petition.domain.user.domain.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class BanListResponse {

    private Long id;

    private User user;

    private User bannedBy;

    private String banReason;

    private LocalDateTime bannedTime;

    public BanListResponse(Ban ban) {
        id = ban.getId();
        user = ban.getUser();
        bannedBy = ban.getBannedBy();
        banReason = ban.getBanReason();
        bannedTime = ban.getBannedTime();
    }

}
