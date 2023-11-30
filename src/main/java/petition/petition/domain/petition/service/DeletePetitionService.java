package petition.petition.domain.petition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.exception.PetitionNotFoundException;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.exception.WriterMisMatchedException;
import petition.petition.domain.user.facade.UserFacade;

import static petition.petition.domain.user.domain.type.Role.ADMIN;

@Service
@RequiredArgsConstructor
@Transactional
public class DeletePetitionService {

    private final PetitionRepository petitionRepository;
    private final UserFacade userFacade;

    public void deletePetition(Long petitionId) {
        User currentUser = userFacade.getCurrentUser();

        Petition petition = petitionRepository.findById(petitionId)
                .orElseThrow(() -> PetitionNotFoundException.EXCEPTION);

        if (!currentUser.equals(petition.getUser()) && currentUser.getRole() != ADMIN) {
            throw WriterMisMatchedException.EXCEPTION;
        }

        petitionRepository.delete(petition);
    }
}