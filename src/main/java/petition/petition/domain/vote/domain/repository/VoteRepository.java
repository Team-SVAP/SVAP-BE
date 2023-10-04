package petition.petition.domain.vote.domain.repository;

import org.springframework.data.repository.CrudRepository;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.vote.domain.Vote;

import java.util.Optional;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    boolean existsByUserAndPetition(User user, Petition petition);

    void deleteByUserAndPetition(User user, Petition petition);

}
