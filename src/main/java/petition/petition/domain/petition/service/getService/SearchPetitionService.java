
package petition.petition.domain.petition.service.getService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchPetitionService {

    private final PetitionRepository petitionRepository;

    public List<PetitionListResponse> searchPetition(String title) {

        return petitionRepository.findAllByTitleContaining(title)
                .stream()
                .map(PetitionListResponse::new)
                .collect(Collectors.toList());
    }

}
