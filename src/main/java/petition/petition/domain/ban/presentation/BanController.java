package petition.petition.domain.ban.presentation;

import lombok.RequiredArgsConstructor;
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
@RequestMapping("/ban")
public class BanController {

    private final CreateBanUserService createBanUserService;
    private final GetBanListService getBanListService;
    private final UnBanService unBanService;

    @PostMapping("/{userId}")
    public void createBan(@PathVariable Long userId, @RequestBody @Valid BanRequest request) {
        createBanUserService.createBan(userId, request);
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
