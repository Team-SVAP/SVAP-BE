package petition.petition.global.security.auth;



import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.domain.repository.UserRepository;
import petition.petition.domain.user.exception.UserNotFoundException;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) {

        User user = userRepository.findByAccountId(accountId)//그냥 유저 없으면 오류 발생
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        return new AuthDetails(user.getAccountId());

     }
}