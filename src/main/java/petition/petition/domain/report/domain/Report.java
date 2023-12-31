package petition.petition.domain.report.domain;

import lombok.*;
import petition.petition.domain.petition.domain.Petition;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String whoReported;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petition_id")
    private Petition petition;

    @Column
    private LocalDate reportTime;

}
