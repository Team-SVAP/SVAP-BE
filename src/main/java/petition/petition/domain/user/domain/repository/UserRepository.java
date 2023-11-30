package petition.petition.domain.user.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import petition.petition.domain.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByAccountId(String accountId);

    Boolean existsByAccountId(String accountId);

    Optional<User> deleteUserByAccountId(String accountId);
}
