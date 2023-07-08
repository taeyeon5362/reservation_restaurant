package Team2.youngcha.hellospring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBooking is a Querydsl query type for Booking
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBooking extends EntityPathBase<Booking> {

    private static final long serialVersionUID = -347264497L;

    public static final QBooking booking = new QBooking("booking");

    public final NumberPath<Long> oid = createNumber("oid", Long.class);

    public final StringPath tableNo = createString("tableNo");

    public QBooking(String variable) {
        super(Booking.class, forVariable(variable));
    }

    public QBooking(Path<? extends Booking> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBooking(PathMetadata metadata) {
        super(Booking.class, metadata);
    }

}

