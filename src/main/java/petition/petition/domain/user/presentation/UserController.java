package petition.petition.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petition.petition.domain.petition.presentation.dto.response.PetitionListResponse;
import petition.petition.domain.user.presentation.dto.request.*;
import petition.petition.domain.user.presentation.dto.response.MyInfoResponse;
import petition.petition.domain.user.service.*;
import petition.petition.global.security.TokenResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/svap/user")
public class UserController {

    private final UserSignupService userSignupService;
    private final LoginService loginService;
    private final ReissueService reissueService;
    private final AdminSignupService adminSignupService;
    private final MyPetitionService myPetitionService;
    private final VerificationService verificationService;
    private final MyInfoService myInfoService;
    private final UserWithdrawalService userWithdrawalService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) {
        return userSignupService.signUp(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin/signup")
    public TokenResponse adminSignup(@RequestBody @Valid AdminSignupRequest request) {
        return adminSignupService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "AUTHORIZATION_HEADER") String refreshToken) {
        return reissueService.reissue(refreshToken);
    }

    @GetMapping
    public List<PetitionListResponse> myPetition() {
        return myPetitionService.myPetition();
    }

    @GetMapping("/my-info")
    public MyInfoResponse myInfo() {
        return myInfoService.myInfo();
    }

    @DeleteMapping
    public void userWithdrawal() {
        userWithdrawalService.userWithdrawal();
    }

    @GetMapping("/verification")
    public void verification(
            @RequestParam(value = "account-id", required = false) String accountId,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "username", required = false) String username
            ) {
        VerificationRequest request = new VerificationRequest(accountId, password, username);
        verificationService.verification(request);
    }

}
