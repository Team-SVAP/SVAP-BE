package petition.petition.domain.petition.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.petition.presentation.dto.request.*;
import petition.petition.domain.petition.presentation.dto.response.PetitionResponse;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;
import petition.petition.domain.petition.service.*;
import petition.petition.domain.petition.service.getService.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/petition")
@RequiredArgsConstructor
public class PetitionController {

    private final CreatePetitionService createPetitionService;
    private final ModifyPetitionService modifyPetitionService;
    private final DeletePetitionService deletePetitionService;
    private final RecentPetitionService recentPetitionService;
    private final GetPetitionService getPetitionService;
    private final RecentAllPetitionService recentAllPetitionService;
    private final AccessedAllPetitionService accessedAllPetitionService;
    private final AccessedPetitionService accessedPetitionService;
    private final WaitingAllPetitionService waitingAllPetitionService;
    private final WaitingPetitionService waitingPetitionService;
    private final VoteAllPetitionService voteAllPetitionService;
    private final VotePetitionService votePetitionService;
    private final SearchPetitionService searchPetitionService;
    private final ChangeWaitingService changeWaitingService;
    private final ChangeAccessService changeAccessService;
    private final ChangeNormalService changeNormalService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPetition(@RequestPart("content") CreatePetitionRequest request,
                               @RequestPart(value = "image", required = false) List<MultipartFile> multipartFiles)
    {
        if (multipartFiles == null) {
            createPetitionService.createPetition(request);
        }
        else {
            createPetitionService.createImagePetition(request, multipartFiles);
        }
    }

    @PatchMapping("/{petitionId}")
    public void modify(@PathVariable Long petitionId , @RequestBody @Valid ModifyPetitionRequest request) {
        modifyPetitionService.modifyPetition(petitionId,request);
    }

    @DeleteMapping("/{petitionId}")
    public void delete(@PathVariable Long petitionId) {
        deletePetitionService.delete(petitionId);
    }

    @GetMapping("/{petitionId}")
    public PetitionResponse getPetition(@PathVariable Long petitionId) {
        return getPetitionService.getPetition(petitionId);
    }

    @GetMapping
    public List<PetitionListResponse> search(@RequestBody @Valid SearchPetitionRequest request) {
        return searchPetitionService.search(request);
    }

    @GetMapping("/recent/{type}")
    public List<PetitionListResponse> getRecent(@PathVariable Types type) {
        return recentPetitionService.getRecent(type);
    }

    @GetMapping("/recent-all")
    public List<PetitionListResponse> allRecent() {
        return recentAllPetitionService.allRecent();
    }

    @GetMapping("/access/{type}")
    public List<PetitionListResponse> getAccessed(@PathVariable Types type) {
        return accessedPetitionService.getAccessed(type);
    }

    @GetMapping("/access-all")
    public List<PetitionListResponse> allAccessed() {
        return accessedAllPetitionService.allAccessed();
    }

    @GetMapping("/wait/{type}")
    public List<PetitionListResponse> getWaiting(@PathVariable Types type) {
        return waitingPetitionService.getWaiting(type);
    }

    @GetMapping("/wait-all")
    public List<PetitionListResponse> allWaiting() {
        return waitingAllPetitionService.allWaiting();
    }

    @GetMapping("/vote/{type}")
    public List<PetitionListResponse> getVote(@PathVariable Types type) {
        return votePetitionService.getVote(type);
    }

    @GetMapping("/vote-all")
    public List<PetitionListResponse> allVote() {
        return voteAllPetitionService.allVote();
    }

    @PatchMapping("/normal/{petitionId}")
    public void changeNormal(@PathVariable Long petitionId) {
        changeNormalService.changeNormal(petitionId);
    }

    @PatchMapping("/wait/{petitionId}")
    public void changeWaiting(@PathVariable Long petitionId) {
        changeWaitingService.changeWait(petitionId);
    }

    @PatchMapping("/access/{petitionId}")
    public void changeAccess(@PathVariable Long petitionId) {
        changeAccessService.changeAccess(petitionId);
    }


}