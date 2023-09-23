package petition.petition.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import petition.petition.domain.petition.domain.Petition;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class MyPetitionResponse {

    private Long id;

    private String title;

    private LocalDateTime dateTime;

    private String location;

    public MyPetitionResponse(Petition petition) {
        id = petition.getId();
        title = petition.getTitle();
        dateTime = petition.getDateTime();
        location = petition.getLocation();
    }
}
