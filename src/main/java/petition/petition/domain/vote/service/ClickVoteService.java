package petition.petition.domain.vote.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.exception.PetitionNotFoundException;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.facade.UserFacade;
import petition.petition.domain.vote.domain.Vote;
import petition.petition.domain.vote.domain.repository.VoteRepository;


@Service
@RequiredArgsConstructor
@Transactional
public class ClickVoteService {

    private final VoteRepository voteRepository;
    private final UserFacade userFacade;
    private final PetitionRepository petitionRepository;

    public void clickVote(Long petitionId) {

        User currentUser = userFacade.getCurrentUser();

        Petition petition = petitionRepository.findById(petitionId)
                .orElseThrow(() -> PetitionNotFoundException.EXCEPTION);

        if(voteRepository.existsByUserAndPetition(currentUser, petition)) {

            voteRepository.deleteByUserAndPetition(currentUser, petition);

            petition.minusVoteCount();
        } else {
            petition.addVoteCount();

            voteRepository.save(
                    Vote.builder()
                            .user(currentUser)
                            .petition(petition)
                            .build());

        }
    }

}
