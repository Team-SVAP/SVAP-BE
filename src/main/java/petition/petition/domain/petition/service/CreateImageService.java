package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.exception.PetitionNotFoundException;
import petition.petition.domain.petition.presentation.dto.response.ImageUrlResponse;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.exception.WriterMisMatchedException;
import petition.petition.domain.user.facade.UserFacade;
import petition.petition.infra.service.S3Service;

import java.util.List;

import static petition.petition.domain.user.domain.type.Role.ADMIN;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateImageService {

    private final UserFacade userFacade;
    private final S3Service s3Service;

    public ImageUrlResponse createImage(List<MultipartFile> multipartFiles) {
        User currentUser = userFacade.getCurrentUser();

        List<String> imgUrlList = s3Service.uploadImages(multipartFiles);

        return new ImageUrlResponse(imgUrlList);
    }

}
