package petition.petition.domain.report.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petition.petition.domain.report.presentation.dto.response.ReportListResponse;
import petition.petition.domain.report.service.CreateReportService;
import petition.petition.domain.report.service.GetReportListService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/svap/report")
public class ReportController {

    private final CreateReportService createReportService;
    private final GetReportListService getReportListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{petition-id}")
    public void createReport(@PathVariable("petition-id") Long id) {
        createReportService.CreateReport(id);
    }

    @GetMapping("/get-list")
    public List<ReportListResponse> getReport() {
        return getReportListService.getReport();
    }

}
