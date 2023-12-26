package petition.petition.domain.petition.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPetition is a Querydsl query type for Petition
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPetition extends EntityPathBase<Petition> {

    private static final long serialVersionUID = 1271161474L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPetition petition = new QPetition("petition");

    public final EnumPath<petition.petition.domain.petition.domain.types.AccessTypes> accessTypes = createEnum("accessTypes", petition.petition.domain.petition.domain.types.AccessTypes.class);

    public final StringPath content = createString("content");

    public final DatePath<java.time.LocalDate> dateTime = createDate("dateTime", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<String, StringPath> imgList = this.<String, StringPath>createList("imgList", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath location = createString("location");

    public final StringPath title = createString("title");

    public final EnumPath<petition.petition.domain.petition.domain.types.Types> types = createEnum("types", petition.petition.domain.petition.domain.types.Types.class);

    public final petition.petition.domain.user.domain.QUser user;

    public final NumberPath<Integer> viewCounts = createNumber("viewCounts", Integer.class);

    public final NumberPath<Integer> voteCounts = createNumber("voteCounts", Integer.class);

    public QPetition(String variable) {
        this(Petition.class, forVariable(variable), INITS);
    }

    public QPetition(Path<? extends Petition> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPetition(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPetition(PathMetadata metadata, PathInits inits) {
        this(Petition.class, metadata, inits);
    }

    public QPetition(Class<? extends Petition> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new petition.petition.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

