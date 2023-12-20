package petition.petition.domain.ban.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petition.petition.domain.ban.presentation.dto.request.CreateBanRequest;
import petition.petition.domain.ban.presentation.dto.response.BanListResponse;
import petition.petition.domain.ban.service.CreateBanUserService;
import petition.petition.domain.ban.service.GetBanListService;
import petition.petition.domain.ban.service.DeleteBanService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/svap/ban")
public class BanController {

    private final CreateBanUserService createBanUserService;
    private final GetBanListService getBanListService;
    private final DeleteBanService deleteBanService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createBan(@RequestBody @Valid CreateBanRequest request) {
        createBanUserService.createBan(request);
    }

    @DeleteMapping("/{ban-id}")
    public void deleteBan(@PathVariable("ban-id") Long id) {
        deleteBanService.deleteBan(id);
    }

    @GetMapping
    public List<BanListResponse> getBan() {
        return getBanListService.getBan();
    }

}
