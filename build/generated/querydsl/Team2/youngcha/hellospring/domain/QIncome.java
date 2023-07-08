package Team2.youngcha.hellospring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIncome is a Querydsl query type for Income
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIncome extends EntityPathBase<Income> {

    private static final long serialVersionUID = 49377587L;

    public static final QIncome income = new QIncome("income");

    public final StringPath dish = createString("dish");

    public final NumberPath<Integer> dishCount = createNumber("dishCount", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> incomeDate = createDate("incomeDate", java.time.LocalDate.class);

    public final NumberPath<Integer> profit = createNumber("profit", Integer.class);

    public QIncome(String variable) {
        super(Income.class, forVariable(variable));
    }

    public QIncome(Path<? extends Income> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIncome(PathMetadata metadata) {
        super(Income.class, metadata);
    }

}

