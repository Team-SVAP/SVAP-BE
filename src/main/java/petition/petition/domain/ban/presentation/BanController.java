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
@RequestMapping("/svap/ban")
public class BanController {

    private final CreateBanUserService createBanUserService;
    private final GetBanListService getBanListService;
    private final UnBanService unBanService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createBan(@RequestBody @Valid BanRequest request) {
        createBanUserService.createBan(request);
    }

    @DeleteMapping("/{ban-id}")
    public void unBan(@PathVariable("ban-id") Long id) {
        unBanService.unBan(id);
    }

    @GetMapping
    public List<BanListResponse> getBan() {
        return getBanListService.getBan();
    }

}
