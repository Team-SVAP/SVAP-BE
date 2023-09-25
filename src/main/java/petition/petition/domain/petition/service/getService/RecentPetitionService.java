package petition.petition.domain.petition.service.getService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.service.facade.UserFacade;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecentPetitionService {
    private final PetitionRepository petitionRepository;
    private final UserFacade userFacade;

    public List<PetitionListResponse> getRecent(Types type) {

        return petitionRepository.findAllByTypesAndAccessTypesOrderByDateTimeDesc(type, AccessTypes.NORMAL)
                .stream()
                .map(PetitionListResponse::new)
                .collect(Collectors.toList());

    }
}
