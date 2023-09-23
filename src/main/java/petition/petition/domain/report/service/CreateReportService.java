package petition.petition.domain.report.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.petition.domain.repository.PetitionRepository;
import petition.petition.domain.petition.exception.PetitionNotFoundException;
import petition.petition.domain.report.domain.Report;
import petition.petition.domain.report.domain.repository.ReportRepository;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.service.facade.UserFacade;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateReportService {

    private final ReportRepository reportRepository;
    private final UserFacade userFacade;
    private final PetitionRepository petitionRepository;

    public void report(Long petitionId) {

        User currentUser = userFacade.getCurrentUser();

        Petition petition = petitionRepository.findById(petitionId)
                .orElseThrow(() -> PetitionNotFoundException.EXCEPTION);

        LocalDateTime now = LocalDateTime.now();

        reportRepository.save(
                Report.builder()
                        .user(currentUser)
                        .petition(petition)
                        .reportTime(now)
                        .build()
        );
    }

}
