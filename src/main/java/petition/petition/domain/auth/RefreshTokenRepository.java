package petition.petition.domain.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,String> {

    Optional<RefreshToken> findByRefreshToken(String token);
}
