package petition.petition.domain.petition.domain.repository;

import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.user.domain.User;

import java.util.List;

public interface PetitionCustomRepository {

    List<Petition> queryPetitionByTypesAndAccessTypes(Types types, AccessTypes accessTypes);

    List<Petition> queryPetitionByAccessTypes(AccessTypes accessTypes);
    
}
