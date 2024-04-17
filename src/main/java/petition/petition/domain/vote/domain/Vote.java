package petition.petition.domain.vote.domain;

import nonapi.io.github.classgraph.json.Id;
import petition.petition.domain.petition.domain.Petition;
import petition.petition.domain.user.domain.User;


@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petition_id")
    private Petition petition;

}
