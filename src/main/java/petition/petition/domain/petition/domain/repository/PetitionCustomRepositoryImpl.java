package petition.petition.domain.petition.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;

import java.util.List;

import static petition.petition.domain.petition.domain.QPetition.petition;

@Repository
@RequiredArgsConstructor
public class PetitionCustomRepositoryImpl implements PetitionCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Petition> queryPetitionByTypesAndAccessTypes(Types types, AccessTypes accessTypes) {
        return jpaQueryFactory
                .selectFrom(petition)
                .where(petition.types.eq(types).and(petition.accessTypes.eq(accessTypes)))
                .orderBy(petition.id.desc())
                .fetch();
    }

    @Override
    public List<Petition> queryPetitionByAccessTypes(AccessTypes accessTypes) {
        return jpaQueryFactory
                .selectFrom(petition)
                .where(petition.accessTypes.eq(accessTypes))
                .orderBy(petition.id.desc())
                .fetch();
    }

}
