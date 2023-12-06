package petition.petition.domain.petition.service.getService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VoteAllPetitionService {

    private final PetitionRepository petitionRepository;

    public List<PetitionListResponse> getAllVoteSortedPetition() {

        return petitionRepository.findAllByOrderByVoteCountsDesc()
                .stream()
                .map(PetitionListResponse::new)
                .toList();
    }
}
