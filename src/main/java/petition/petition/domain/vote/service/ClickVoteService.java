package petition.petition.domain.vote.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.exception.PetitionNotFoundException;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.service.facade.UserFacade;
import petition.petition.domain.vote.domain.Vote;
import petition.petition.domain.vote.domain.repository.VoteRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClickVoteService {

    private final VoteRepository voteRepository;
    private final UserFacade userFacade;
    private final PetitionRepository petitionRepository;

    public void clickVote(Long petitionId) {

        User currentUser = userFacade.getCurrentUser();

        Petition petition = petitionRepository.findById(petitionId)
                .orElseThrow(() -> PetitionNotFoundException.EXCEPTION);

        Optional<Vote> existVote = voteRepository.findByUserAndPetition(currentUser, petition);

        if(existVote.isPresent())
        {
            voteRepository.delete(existVote.get());

            petition.minusVoteCount();
        }
        else if (!existVote.isPresent())
        {

            petition.addVoteCount();

            Vote vote = Vote.builder()
                    .user(currentUser)
                    .petition(petition)
                    .build();

            voteRepository.save(vote);
        }
    }
}
