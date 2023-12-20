package petition.petition.domain.ban.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petition.petition.domain.ban.domain.Ban;
import petition.petition.domain.user.domain.User;

public interface BanRepository extends JpaRepository<Ban, Long> {

    Boolean existsByUser(User user);

    void deleteBanById(Long id);

}
