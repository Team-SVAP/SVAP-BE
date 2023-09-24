package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.exception.PetitionNotFoundException;
import petition.petition.domain.petition.presentation.dto.response.PetitionResponse;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.service.facade.UserFacade;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetPetitionService {
    private final PetitionRepository petitionRepository;

    private final UserFacade userFacade;

    public PetitionResponse get(Long petitionId) {

        User currentUser = userFacade.getCurrentUser();

        Petition petition = petitionRepository.findById(petitionId)
                .orElseThrow(() -> PetitionNotFoundException.EXCEPTION);

        petition.addViewCount();

        return PetitionResponse.of(petition);
    }
}
