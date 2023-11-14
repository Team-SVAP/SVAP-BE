package petition.petition.domain.petition.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.user.domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Builder
@Getter
public class PetitionResponse {

    private Long id;

    private String title;

    private String content;

    private int voteCounts;

    private AccessTypes accessTypes;

    private Types types;

    private String location;

    private int viewCounts;

    private String accountId;

    private LocalDate dateTime;

    private List<String> imgUrl;

    private boolean isVoted;

    public static PetitionResponse of(Petition petition, boolean isVoted) {

        return PetitionResponse.builder()
                .id(petition.getId())
                .title(petition.getTitle())
                .content(petition.getContent())
                .voteCounts(petition.getVoteCounts())
                .accessTypes(petition.getAccessTypes())
                .types(petition.getTypes())
                .location(petition.getLocation())
                .viewCounts(petition.getViewCounts())
                .accountId(petition.getUser().getAccountId())
                .dateTime(petition.getDateTime())
                .imgUrl(petition.getImgList())
                .isVoted(isVoted)
                .build();

    }

}
