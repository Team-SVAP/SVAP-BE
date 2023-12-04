package petition.petition.domain.ban.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petition.petition.domain.ban.presentation.dto.request.BanRequest;
import petition.petition.domain.ban.presentation.dto.response.BanListResponse;
import petition.petition.domain.ban.service.CreateBanUserService;
import petition.petition.domain.ban.service.GetBanListService;
import petition.petition.domain.ban.service.UnBanService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("svap/ban")
public class BanController {

    private final CreateBanUserService createBanUserService;
    private final GetBanListService getBanListService;
    private final UnBanService unBanService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{accountId}")
    public void createBan(@PathVariable String accountId, @RequestBody @Valid BanRequest request) {
        createBanUserService.createBan(accountId, request);
    }

    @DeleteMapping("/{banId}")
    public void unBan(@PathVariable Long banId) {
        unBanService.unBan(banId);
    }

    @GetMapping
    public List<BanListResponse> getBan() {
        return getBanListService.getBan();
    }
}
