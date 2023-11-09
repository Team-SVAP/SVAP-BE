package petition.petition.domain.petition.service.getService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetSortedPetitionService {
    private final PetitionRepository petitionRepository;

    public List<PetitionListResponse> getSortedPetition(Types type, AccessTypes accessTypes) {

        return petitionRepository.queryPetitionByTypesAndAccessTypes(type, accessTypes)
                .stream()
                .map(PetitionListResponse::new)
                .collect(Collectors.toList());

    }
}
