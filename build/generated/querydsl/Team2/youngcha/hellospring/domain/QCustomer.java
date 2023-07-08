package Team2.youngcha.hellospring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = 720606440L;

    public static final QCustomer customer = new QCustomer("customer");

    public final StringPath cid = createString("cid");

    public final StringPath email = createString("email");

    public final BooleanPath emailReceive = createBoolean("emailReceive");

    public final StringPath gender = createString("gender");

    public final BooleanPath isAdmin = createBoolean("isAdmin");

    public final BooleanPath messageReceive = createBoolean("messageReceive");

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath psw = createString("psw");

    public final StringPath rank = createString("rank");

    public final NumberPath<Integer> reservation_count = createNumber("reservation_count", Integer.class);

    public QCustomer(String variable) {
        super(Customer.class, forVariable(variable));
    }

    public QCustomer(Path<? extends Customer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomer(PathMetadata metadata) {
        super(Customer.class, metadata);
    }

}

