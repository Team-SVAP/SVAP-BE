package petition.petition.domain.petition.service.getService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetSortedPetitionService {

    private final PetitionRepository petitionRepository;

    public List<PetitionListResponse> getSortedPetition(Types types, AccessTypes accessTypes) {

        if (types == Types.ALL && accessTypes == AccessTypes.VOTE) {
            return petitionRepository.findAllByOrderByVoteCountsDesc()
                    .stream()
                    .map(PetitionListResponse::new)
                    .toList();
        } else if (accessTypes == AccessTypes.VOTE) {
            return petitionRepository.findAllByTypesOrderByVoteCountsDesc(types)
                    .stream()
                    .map(PetitionListResponse::new)
                    .toList();
        } else if (types == Types.ALL) {
            return petitionRepository.queryPetitionByAccessTypes(accessTypes)
                    .stream()
                    .map(PetitionListResponse::new)
                    .toList();
        }
        else {
            return petitionRepository.queryPetitionByTypesAndAccessTypes(types, accessTypes)
                    .stream()
                    .map(PetitionListResponse::new)
                    .toList();
        }

    }

}
