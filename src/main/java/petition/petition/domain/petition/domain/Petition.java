package petition.petition.domain.petition.domain;

import lombok.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWarDeployment;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.user.domain.User;
import petition.petition.domain.vote.domain.Vote;
import petition.petition.infra.StringListConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Petition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String title;

    @Column(columnDefinition = "text", nullable = false)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Types types;

    @Column(columnDefinition = "varchar(12)", nullable = false)
    private String location;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccessTypes accessTypes;

    @Column(nullable = false)
    private LocalDate dateTime;

    @Column
    private int voteCounts;

    @Column
    private int viewCounts;

    @Convert(converter = StringListConverter.class)
    private List<String> imgList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "petition", cascade = CascadeType.REMOVE)
    @JoinColumn(name = "vote_id")
    private List<Vote> voteList = new ArrayList<>();

    public void modifyPetition(String title, String content, Types types, String location) {
        this.title = title;
        this.content = content;
        this.types = types;
        this.location = location;
    }

    public void addViewCount() {
        this.viewCounts++;
    }
    public void changeAccessType(AccessTypes accessTypes) {
        this.accessTypes = accessTypes;
    }

    public void addVoteCount()  {
        this.voteCounts++;
    }

    public void minusVoteCount()  {
        this.voteCounts--;
    }
}
