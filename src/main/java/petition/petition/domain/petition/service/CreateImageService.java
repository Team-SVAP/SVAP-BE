package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import petition.petition.domain.petition.presentation.dto.response.ImageUrlResponse;
import petition.petition.infra.service.S3Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class CreateImageService {

    private final S3Service s3Service;

    public ImageUrlResponse createImage(List<MultipartFile> multipartFiles) {

        List<String> imgUrlList = s3Service.uploadImages(multipartFiles);

        return new ImageUrlResponse(imgUrlList);
    }

}
