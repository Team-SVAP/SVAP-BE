package petition.petition.domain.ban.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBan is a Querydsl query type for Ban
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBan extends EntityPathBase<Ban> {

    private static final long serialVersionUID = 871591790L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBan ban = new QBan("ban");

    public final StringPath bannedBy = createString("bannedBy");

    public final DatePath<java.time.LocalDate> bannedTime = createDate("bannedTime", java.time.LocalDate.class);

    public final StringPath banReason = createString("banReason");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final petition.petition.domain.user.domain.QUser user;

    public QBan(String variable) {
        this(Ban.class, forVariable(variable), INITS);
    }

    public QBan(Path<? extends Ban> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBan(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBan(PathMetadata metadata, PathInits inits) {
        this(Ban.class, metadata, inits);
    }

    public QBan(Class<? extends Ban> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new petition.petition.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

