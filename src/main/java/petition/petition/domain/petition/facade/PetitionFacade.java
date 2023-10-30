package petition.petition.domain.petition.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.user.exception.UserNotFoundException;

@RequiredArgsConstructor
@Component
public class PetitionFacade {

    private final PetitionRepository petitionRepository;

    public Petition getCurrentPetition(Long petitionId) {
        return petitionRepository.findById(petitionId).orElseThrow(() -> UserNotFoundException.EXCEPTION);

    }

}
