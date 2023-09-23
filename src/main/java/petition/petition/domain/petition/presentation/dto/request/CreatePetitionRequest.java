package petition.petition.domain.petition.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import petition.petition.domain.petition.domain.types.Types;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePetitionRequest {

    private String title;

    private String content;

    private Types types;

    private String location;

}
