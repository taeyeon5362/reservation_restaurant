package Team2.youngcha.hellospring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenu is a Querydsl query type for Menu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMenu extends EntityPathBase<Menu> {

    private static final long serialVersionUID = 2073902953L;

    public static final QMenu menu = new QMenu("menu");

    public final StringPath dish = createString("dish");

    public final DatePath<java.time.LocalDate> lastRestockedDate = createDate("lastRestockedDate", java.time.LocalDate.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> restockRate = createNumber("restockRate", Integer.class);

    public final NumberPath<Integer> salesCount = createNumber("salesCount", Integer.class);

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    public QMenu(String variable) {
        super(Menu.class, forVariable(variable));
    }

    public QMenu(Path<? extends Menu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenu(PathMetadata metadata) {
        super(Menu.class, metadata);
    }

}

