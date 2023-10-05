package petition.petition.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;
import petition.petition.domain.user.presentation.dto.request.AdminSignupRequest;
import petition.petition.domain.user.presentation.dto.request.LoginRequest;
import petition.petition.domain.user.presentation.dto.request.SignupRequest;
import petition.petition.domain.user.service.*;
import petition.petition.global.security.TokenResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserSignupService userSignupService;
    private final LoginService loginService;
    // final ReissueService reissueService;
    private final AdminSignupService adminSignupService;
    private final MyPetitionService myPetitionService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignupRequest request) {
        userSignupService.signUp(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin/signup")
    public void adminSignup(@RequestBody @Valid AdminSignupRequest request) {
        adminSignupService.signUp(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }

    /*
    @PostMapping("/reissue")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse reissue(@RequestHeader(name = "AUTHORIZATION_HEADER") String refreshToken) {
        return reissueService.reissue(refreshToken);
    }*/

    @GetMapping
    public List<PetitionListResponse> myPetition() {
        return myPetitionService.myPetition();

    }
}