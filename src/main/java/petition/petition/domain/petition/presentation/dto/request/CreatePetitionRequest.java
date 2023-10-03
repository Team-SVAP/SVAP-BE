package petition.petition.domain.petition.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import petition.petition.domain.petition.domain.types.Types;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePetitionRequest {

    @NotNull(message = "title은 null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 50, message = "title은 최대 50자까지 가능합니다.")
    private String title;

    @NotNull(message = "content은 null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 5000, message = "content은 최대 5000자까지 가능합니다.")
    private String content;

    @NotNull(message = "타입을 입력하세요")
    private Types types;

    @Size(min = 1, max = 10, message = "아이디는 최소 5자, 최대 10자 입니다.")
    private String location;

}
