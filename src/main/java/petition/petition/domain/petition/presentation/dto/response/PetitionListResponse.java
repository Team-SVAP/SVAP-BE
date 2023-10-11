package petition.petition.domain.petition.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.types.Types;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PetitionListResponse {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime dateTime;

    private Types types;

    private String location;


    public PetitionListResponse(Petition petition) {
        id = petition.getId();
        title = petition.getTitle();
        content = petition.getContent();
        dateTime = petition.getDateTime();
        types = petition.getTypes();
        location = petition.getLocation();
    }
}
