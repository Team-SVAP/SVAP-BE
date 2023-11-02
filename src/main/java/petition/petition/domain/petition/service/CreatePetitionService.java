package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.presentation.dto.request.CreatePetitionRequest;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.facade.UserFacade;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class CreatePetitionService {

    private final PetitionRepository petitionRepository;
    private final UserFacade userFacade;

    public void createPetition(CreatePetitionRequest request) {

        User currentUser = userFacade.getCurrentUser();

        LocalDate dateTime = LocalDate.now();

        petitionRepository.save(
                Petition.builder()
                        .user(currentUser)
                        .title(request.getTitle())
                        .content(request.getContent())
                        .accessTypes(AccessTypes.NORMAL)
                        .types(request.getTypes())
                        .imgList(request.getImageUrl())
                        .location(request.getLocation())
                        .dateTime(dateTime)
                        .build());
    }

}
