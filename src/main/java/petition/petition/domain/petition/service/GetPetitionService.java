package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.exception.PetitionNotFoundException;
import petition.petition.domain.petition.presentation.dto.response.PetitionResponse;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.facade.UserFacade;
import petition.petition.domain.vote.domain.repository.VoteRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetPetitionService {

    private final VoteRepository voteRepository;
    private final PetitionRepository petitionRepository;
    private final UserFacade userFacade;

    public PetitionResponse getPetition(Long petitionId) {

        Petition petition = petitionRepository.findById(petitionId)
                .orElseThrow(() -> PetitionNotFoundException.EXCEPTION);

        petition.addViewCount();

        Optional<User> currentUser = userFacade.getUser();

        boolean isVoted = voteRepository.existsByUserAndPetition(currentUser,petition);

        return PetitionResponse.of(petition,isVoted);


    }
    
}
