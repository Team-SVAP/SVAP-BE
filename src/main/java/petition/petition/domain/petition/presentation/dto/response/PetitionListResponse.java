package petition.petition.domain.petition.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import petition.petition.domain.petition.domain.Petition;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PetitionListResponse {

    private Long id;

    private String title;

    private LocalDateTime dateTime;

    private String location;

    public PetitionListResponse(Petition petition) {
        id = petition.getId();
        title = petition.getTitle();
        dateTime = petition.getDateTime();
        location = petition.getLocation();
    }
}
