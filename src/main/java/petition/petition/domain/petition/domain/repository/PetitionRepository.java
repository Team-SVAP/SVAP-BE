package petition.petition.domain.petition.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface PetitionRepository extends JpaRepository<Petition, Long>, PetitionCustomRepository {

    //type 으로 투표순으로 청원보기
    List<Petition> findAllByTypesOrderByVoteCountsDesc(Types types);

    //투표순으로 청원 보기
    List<Petition> findAllByOrderByVoteCountsDesc();

    //내 청원 보기
    List<Petition> findAllByUser(User user);

    //제목으로 검색
    List<Petition> findAllByTitleContaining(String title);

    //인기 청원 보기
    Optional<Petition> findTopByOrderByViewCountsDesc();

}
