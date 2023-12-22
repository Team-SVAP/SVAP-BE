package petition.petition.domain.vote.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import petition.petition.domain.vote.service.ClickVoteService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/svap/vote")
public class VoteController {

    private final ClickVoteService clickVoteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{petition-id}")
    public void clickVote(@PathVariable(value = "petition-id") Long id) {
        clickVoteService.clickVote(id);

    }

}
