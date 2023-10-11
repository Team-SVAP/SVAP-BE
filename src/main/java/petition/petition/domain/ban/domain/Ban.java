package petition.petition.domain.ban.domain;

import lombok.*;
import petition.petition.domain.user.domain.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Ban {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String bannedBy;

    @Column(columnDefinition = "text", nullable = false)
    private String banReason;

    private LocalDate bannedTime;
}