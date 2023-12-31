package petition.petition.domain.user.domain;

import lombok.*;
import petition.petition.domain.user.domain.type.Role;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(5)", nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}
