package petition.petition.domain.petition.service.getService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;
import petition.petition.domain.user.facade.UserFacade;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VotePetitionService {

    private final PetitionRepository petitionRepository;
    private final UserFacade userFacade;

    public List<PetitionListResponse> getVote(Types type) {

        return petitionRepository.findAllByTypes(type)
                .stream()
                .sorted(Comparator.comparingInt(Petition::getVoteCounts).reversed())
                .map(PetitionListResponse::new)
                .collect(Collectors.toList());
    }
}