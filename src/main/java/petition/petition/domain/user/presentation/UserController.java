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
    private final CheckAccountIdService checkAccountIdService;
    private final CheckUsernameService checkUsernameService;
    private final CheckPasswordService checkPasswordService;
    private final MyInfoService myInfoService;
    private final UserWithdrawalService userWithdrawalService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) {
        return userSignupService.signUp(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin/signup")
    public TokenResponse adminSignup(@RequestBody @Valid AdminSignupRequest request) {
        return adminSignupService.signUp(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/reissue")
    @ResponseStatus(HttpStatus.CREATED)
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

    @PostMapping("/ck-account-id")
    public void checkAccountId(@RequestBody @Valid CheckAccountIdRequest request) {
        checkAccountIdService.checkAccountId(request);

    }

    @PostMapping("/ck-username")
    public void checkUsername(@RequestBody @Valid CheckUsernameRequest request) {
        checkUsernameService.checkUsername(request);

    }

    @PostMapping("/ck-password")
    public void checkPassword(@RequestBody @Valid CheckPasswordRequest request) {
        checkPasswordService.checkPassword(request);

    }

}
