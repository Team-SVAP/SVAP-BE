package petition.petition.domain.petition.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.user.domain.User;

import java.util.List;

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

    private Long userId;

    private List<String> imgUrl;

    public static PetitionResponse of(Petition petition) {

        return PetitionResponse.builder()
                .id(petition.getId())
                .title(petition.getTitle())
                .content(petition.getContent())
                .voteCounts(petition.getVoteCounts())
                .accessTypes(petition.getAccessTypes())
                .types(petition.getTypes())
                .location(petition.getLocation())
                .viewCounts(petition.getViewCounts())
                .userId(petition.getUser().getId())
                .imgUrl(petition.getImgList())
                .build();

    }

}
