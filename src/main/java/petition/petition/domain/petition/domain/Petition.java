package petition.petition.domain.petition.domain;

import lombok.*;
import petition.petition.domain.petition.domain.types.AccessTypes;
import petition.petition.domain.petition.domain.types.Types;
import petition.petition.domain.user.domain.User;
import petition.petition.infra.StringListConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @Column(columnDefinition = "varchar(8)", nullable = false)
    private String location;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccessTypes accessTypes;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    private int voteCounts;

    @Convert(converter = StringListConverter.class)
    private List<String> imgList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void modifyPetition(String title, String content, Types types, String location) {
        this.title = title;
        this.content = content;
        this.types = types;
        this.location = location;
    }

    public void changeAccessType(AccessTypes accessTypes) {
        this.accessTypes = accessTypes;
    }

    public void imageListUpload(List<String> imgList) {
        this.imgList = imgList;
    }

    public void addVoteCount()  {
        this.voteCounts++;
    }

    public void minusVoteCount()  {
        this.voteCounts--;
    }
}
