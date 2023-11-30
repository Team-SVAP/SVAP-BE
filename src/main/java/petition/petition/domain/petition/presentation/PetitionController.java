package petition.petition.domain.petition.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.petition.presentation.dto.request.*;
import petition.petition.domain.petition.presentation.dto.response.ImageUrlResponse;
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
    private final VotePetitionService votePetitionService;
    private final GetPetitionService getPetitionService;
    private final VoteAllPetitionService voteAllPetitionService;
    private final AllSortedPetitionService allSortedPetitionService;
    private final GetSortedPetitionService getSortedPetitionService;
    private final SearchPetitionService searchPetitionService;
    private final ChangeWaitingService changeWaitingService;
    private final ChangeAccessService changeAccessService;
    private final ChangeNormalService changeNormalService;
    private final GetPopularPetitionService getPopularPetitionService;
    private final CreateImageService createImageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPetition(@RequestBody @Valid CreatePetitionRequest request) {
            createPetitionService.createPetition(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/image")
    public ImageUrlResponse createImage(@RequestPart(value = "image", required = false) List<MultipartFile> multipartFiles) {
        return createImageService.createImage(multipartFiles);
    }

    @PatchMapping("/{petitionId}")
    public void modifyPetition(@PathVariable Long petitionId , @RequestBody @Valid ModifyPetitionRequest request) {
        modifyPetitionService.modifyPetition(petitionId,request);
    }

    @DeleteMapping("/{petitionId}")
    public void deletePetition(@PathVariable Long petitionId) {
        deletePetitionService.deletePetition(petitionId);
    }

    @GetMapping("/{petitionId}")
    public PetitionResponse getPetition(@PathVariable Long petitionId) {
        return getPetitionService.getPetition(petitionId);
    }

    @GetMapping("/popular")
    public PetitionListResponse getPopularPetition() {
        return getPopularPetitionService.getPopularPetition();
    }

    @PostMapping("/search")
    public List<PetitionListResponse> searchPetition(@RequestBody @Valid SearchPetitionRequest request) {
        return searchPetitionService.searchPetition(request);
    }

    @GetMapping("/vote/{type}")
    public List<PetitionListResponse> getVoteSortedPetition(@PathVariable Types type) {
        return votePetitionService.getVoteSortedPetition(type);
    }

    @GetMapping("/vote-all")
    public List<PetitionListResponse> getAllVoteSortedPetition() {
        return voteAllPetitionService.getAllVoteSortedPetition();
    }

    @GetMapping("/sort/{type}/{accessTypes}")
    public List<PetitionListResponse> getSortedPetition(@PathVariable Types type, @PathVariable AccessTypes accessTypes) {
        return getSortedPetitionService.getSortedPetition(type, accessTypes);
    }

    @GetMapping("/sort-all/{accessTypes}")
    public List<PetitionListResponse> allSortedPetitionService(@PathVariable AccessTypes accessTypes) {
        return allSortedPetitionService.allSortedPetition(accessTypes);
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
