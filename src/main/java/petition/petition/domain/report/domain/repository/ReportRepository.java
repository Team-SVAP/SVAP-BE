package petition.petition.domain.report.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petition.petition.domain.report.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
