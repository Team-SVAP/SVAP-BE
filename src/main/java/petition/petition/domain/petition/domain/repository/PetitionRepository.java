package petition.petition.domain.petition.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface PetitionRepository extends JpaRepository<Petition, Long>, PetitionCustomRepository {

    //모든 청원 조회 (남겨)
    List<Petition> findAllByOrderByDateTimeDesc();

    //내 청원 보기 (남겨)
    List<Petition> findAllByUser(User user);

    //제목으로 검색 (남겨)
    List<Petition> findAllByTitleContaining(String title);

    //인기 청원 보기 (남겨)
    Optional<Petition> findTopByOrderByViewCountsDesc();

}
