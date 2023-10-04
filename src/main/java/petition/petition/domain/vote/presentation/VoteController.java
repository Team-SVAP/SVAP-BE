package petition.petition.domain.vote.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import petition.petition.domain.vote.service.ClickVoteService;

@Service
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final ClickVoteService clickVoteService;

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{petitionId}")
    public void clickVote(@PathVariable Long petitionId) {
        clickVoteService.clickVote(petitionId);
    }

}

