package Team2.youngcha.hellospring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = 1548982914L;

    public static final QReservation reservation = new QReservation("reservation");

    public final QBooking _super = new QBooking(this);

    public final DateTimePath<java.time.LocalDateTime> arrivalTime = createDateTime("arrivalTime", java.time.LocalDateTime.class);

    public final StringPath customerEmail = createString("customerEmail");

    public final StringPath customerID = createString("customerID");

    public final StringPath customerName = createString("customerName");

    public final StringPath dishCounts = createString("dishCounts");

    public final StringPath dishes = createString("dishes");

    public final BooleanPath hasCar = createBoolean("hasCar");

    public final StringPath numberOfPeople = createString("numberOfPeople");

    //inherited
    public final NumberPath<Long> oid = _super.oid;

    public final DateTimePath<java.time.LocalDateTime> reservationDate = createDateTime("reservationDate", java.time.LocalDateTime.class);

    public final StringPath tableNo = createString("tableNo");

    public QReservation(String variable) {
        super(Reservation.class, forVariable(variable));
    }

    public QReservation(Path<? extends Reservation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservation(PathMetadata metadata) {
        super(Reservation.class, metadata);
    }

}

