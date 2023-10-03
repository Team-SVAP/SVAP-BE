package petition.petition.domain.report.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.petition.exception.NotAdminException;
import petition.petition.domain.report.domain.Report;
import petition.petition.domain.report.domain.repository.ReportRepository;
import petition.petition.domain.report.presentation.dto.response.ReportListResponse;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.user.service.facade.UserFacade;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static petition.petition.domain.user.domain.type.Role.ADMIN;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class GetReportListService {

    private final ReportRepository reportRepository;
    private final UserFacade userFacade;

    public List<ReportListResponse> getReport() {

        User currentUser = userFacade.getCurrentUser();

        if (currentUser.getRole() != ADMIN) {
            throw NotAdminException.EXCEPTION;
        }

        List<Report> reports = reportRepository.findAll();

        // 역순 정렬
        reports.sort(Comparator.comparing(Report::getReportTime).reversed());

        return reports.stream()
                .map(ReportListResponse::new)
                .collect(Collectors.toList());
    }

}
