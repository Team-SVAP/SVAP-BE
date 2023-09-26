package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.exception.PetitionNotFoundException;
import petition.petition.domain.petition.presentation.dto.response.PetitionResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class GetPetitionService {
    private final PetitionRepository petitionRepository;

    public PetitionResponse getPetition(Long petitionId) {

        Petition petition = petitionRepository.findById(petitionId)
                .orElseThrow(() -> PetitionNotFoundException.EXCEPTION);

        petition.addViewCount();

        return PetitionResponse.of(petition);
    }
}
