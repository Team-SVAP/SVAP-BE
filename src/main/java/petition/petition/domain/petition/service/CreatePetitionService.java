package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.presentation.dto.request.CreatePetitionRequest;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.service.facade.UserFacade;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CreatePetitionService {

    private final PetitionRepository petitionRepository;
    private final UserFacade userFacade;

    public void createPetition(CreatePetitionRequest request, List<String> imgList) {

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

        petition.imageListUpload(imgList);

        petitionRepository.save(petition);

    }
}