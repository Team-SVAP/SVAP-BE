package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.exception.PetitionNotFoundException;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;

@Service
@RequiredArgsConstructor
public class GetPopularPetitionService {
    private final PetitionRepository petitionRepository;

    public PetitionListResponse getPopular() {

        Petition petition = petitionRepository.findTopByOrderByViewCountsDesc()
                .orElseThrow(() -> PetitionNotFoundException.EXCEPTION);

        return new PetitionListResponse(petition);
    }
}