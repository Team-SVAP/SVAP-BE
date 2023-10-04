package petition.petition.domain.petition.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.user.domain.User;

import java.util.List;

public interface PetitionRepository extends JpaRepository<Petition, Long> {

    //모든 청원 조회
    List<Petition> findAllOrderByDateTimeDesc();

    //특정 타입 청원 조회
    List<Petition> findAllByTypesAndAccessTypesOrderByDateTimeDesc(Types types, AccessTypes accessTypes);

    //투표순으로 청원 조회
    List<Petition> findAllByTypes(Types types);

    List<Petition> findAllByUser(User user);

    //제목으로 검색
    List<Petition> findAllByTitleContaining(String title);
}
