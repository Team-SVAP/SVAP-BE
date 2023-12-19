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
@RequestMapping("/svap/petition")
@RequiredArgsConstructor
public class PetitionController {

    private final CreatePetitionService createPetitionService;
    private final ModifyPetitionService modifyPetitionService;
    private final DeletePetitionService deletePetitionService;
    private final GetPetitionService getPetitionService;
    private final GetSortedPetitionService getSortedPetitionService;
    private final SearchPetitionService searchPetitionService;
    private final ChangeAccessTypeService changeAccessTypeService;
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

    @PatchMapping("/{petition-id}")
    public void modifyPetition(@PathVariable("petition-id") Long id, @RequestBody @Valid ModifyPetitionRequest request) {
        modifyPetitionService.modifyPetition(id,request);
    }

    @DeleteMapping("/{petition-id}")
    public void deletePetition(@PathVariable("petition-id") Long id) {
        deletePetitionService.deletePetition(id);
    }

    @GetMapping("/{petition-id}")
    public PetitionResponse getPetition(@PathVariable("petition-id") Long id) {
        return getPetitionService.getPetition(id);
    }

    @GetMapping("/popular")
    public PetitionListResponse getPopularPetition() {
        return getPopularPetitionService.getPopularPetition();
    }

    @GetMapping("/search")
    public List<PetitionListResponse> searchPetition(@RequestParam(value = "title") String title) {
        return searchPetitionService.searchPetition(title);
    }

    @GetMapping("/sort/{type}/{accessTypes}")
    public List<PetitionListResponse> getSortedPetition(
            @RequestParam(value = "types") Types type,
            @RequestParam(value = "access_types") AccessTypes accessTypes) {
        return getSortedPetitionService.getSortedPetition(type, accessTypes);
    }

    @PatchMapping("/normal/{petition-id}")
    public void changeNormal(@PathVariable("petition-id") Long id) {
        changeNormalService.changeNormal(id);
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
