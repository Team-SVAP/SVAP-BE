package petition.petition.domain.vote.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import petition.petition.domain.vote.service.ClickVoteService;

@Service
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final ClickVoteService clickVoteService;

    @PostMapping("/{petitionId}")
    public void clickVote(@PathVariable Long petitionId) {
        clickVoteService.clickVote(petitionId);
    }

}

