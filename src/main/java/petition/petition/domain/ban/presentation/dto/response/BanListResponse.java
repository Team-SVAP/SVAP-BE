package petition.petition.domain.ban.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import petition.petition.domain.ban.domain.Ban;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class BanListResponse {

    private Long id;

    private String userName;

    private String accountId;

    private String bannedBy;

    private String banReason;

    private LocalDate bannedTime;

    public BanListResponse(Ban ban) {
        id = ban.getId();
        userName = ban.getUser().getUserName();
        accountId = ban.getUser().getAccountId();
        bannedBy = ban.getBannedBy();
        banReason = ban.getBanReason();
        bannedTime = ban.getBannedTime();
    }

}