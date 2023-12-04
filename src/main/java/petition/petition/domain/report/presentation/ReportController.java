package petition.petition.domain.report.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import petition.petition.domain.report.presentation.dto.response.ReportListResponse;
import petition.petition.domain.report.service.CreateReportService;
import petition.petition.domain.report.service.GetReportListService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/svap/report")
public class ReportController {

    private final CreateReportService reportService;
    private final GetReportListService getReportListService;

    @PostMapping("/{petitionId}")
    public void report(@PathVariable Long petitionId) {
        reportService.report(petitionId);
    }

    @GetMapping("/get-list")
    public List<ReportListResponse> getReport() {
        return getReportListService.getReport();
    }

}
