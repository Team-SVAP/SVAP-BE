package petition.petition.domain.vote.domain.repository;

import org.springframework.data.repository.CrudRepository;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.vote.domain.Vote;

import java.util.Optional;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    Optional<Vote> findByUserAndPetition(User user, Petition petition);
}
