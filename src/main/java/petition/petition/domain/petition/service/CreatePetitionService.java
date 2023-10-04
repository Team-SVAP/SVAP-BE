package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.presentation.dto.request.CreatePetitionRequest;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.service.facade.UserFacade;
import petition.petition.infra.service.S3Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CreatePetitionService {

    private final PetitionRepository petitionRepository;
    private final UserFacade userFacade;
    private final S3Service s3Service;

    public void createImagePetition(CreatePetitionRequest request, List<MultipartFile> multipartFiles) {
        User currentUser = userFacade.getCurrentUser();

        List<String> imgList = s3Service.upload(multipartFiles);

        LocalDateTime now = LocalDateTime.now();

        Petition petition = petitionRepository.save(
                Petition.builder()
                        .user(currentUser)
                        .title(request.getTitle())
                        .content(request.getContent())
                        .accessTypes(AccessTypes.NORMAL)
                        .types(request.getTypes())
                        .location(request.getLocation())
                        .imgList(imgList)
                        .dateTime(now)
                        .build()
        );

        //petition.imageListUpload(imgList); //나 코드 완전 더럽게 짰네

        petitionRepository.save(petition);

    }

    public void createPetition(CreatePetitionRequest request) {
        User currentUser = userFacade.getCurrentUser();

        LocalDateTime now = LocalDateTime.now();

        Petition petition = petitionRepository.save(
                Petition.builder()
                        .user(currentUser)
                        .title(request.getTitle())
                        .content(request.getContent())
                        .accessTypes(AccessTypes.NORMAL)
                        .types(request.getTypes())
                        .location(request.getLocation())
                        .dateTime(now)
                        .build()
        );

        petitionRepository.save(petition);

    }
}