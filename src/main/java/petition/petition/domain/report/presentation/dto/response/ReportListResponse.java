package petition.petition.domain.report.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.report.domain.Report;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ReportListResponse {

    private Long id;

    private String title;

    private Long petitionId;

    private LocalDateTime reportTime;

    public ReportListResponse(Report report) {
        id = report.getId();
        title = report.getPetition().getTitle();
        petitionId = report.getPetition().getId();
        reportTime = report.getReportTime();
    }

}
