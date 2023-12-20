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
import petition.petition.domain.user.facade.UserFacade;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateReportService {

    private final ReportRepository reportRepository;
    private final UserFacade userFacade;
    private final PetitionRepository petitionRepository;

    public void CreateReport(Long petitionId) {

        User currentUser = userFacade.getCurrentUser();

        Petition petition = petitionRepository.findById(petitionId)
                .orElseThrow(() -> PetitionNotFoundException.EXCEPTION);

        LocalDate dateTime = LocalDate.now();

        reportRepository.save(
                Report.builder()
                        .whoReported(currentUser.getUserName())
                        .petition(petition)
                        .reportTime(dateTime)
                        .build()
        );
    }

}
