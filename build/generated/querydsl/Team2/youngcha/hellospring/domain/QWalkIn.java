package Team2.youngcha.hellospring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWalkIn is a Querydsl query type for WalkIn
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWalkIn extends EntityPathBase<WalkIn> {

    private static final long serialVersionUID = 438443096L;

    public static final QWalkIn walkIn = new QWalkIn("walkIn");

    public final QBooking _super = new QBooking(this);

    public final StringPath guestCount = createString("guestCount");

    //inherited
    public final NumberPath<Long> oid = _super.oid;

    //inherited
    public final StringPath tableNo = _super.tableNo;

    public final DateTimePath<java.time.LocalDateTime> walkInDate = createDateTime("walkInDate", java.time.LocalDateTime.class);

    public QWalkIn(String variable) {
        super(WalkIn.class, forVariable(variable));
    }

    public QWalkIn(Path<? extends WalkIn> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWalkIn(PathMetadata metadata) {
        super(WalkIn.class, metadata);
    }

}

