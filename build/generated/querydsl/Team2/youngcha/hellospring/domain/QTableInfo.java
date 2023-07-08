package Team2.youngcha.hellospring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTableInfo is a Querydsl query type for TableInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTableInfo extends EntityPathBase<TableInfo> {

    private static final long serialVersionUID = 1558514130L;

    public static final QTableInfo tableInfo = new QTableInfo("tableInfo");

    public final NumberPath<Integer> people = createNumber("people", Integer.class);

    public final NumberPath<Integer> places = createNumber("places", Integer.class);

    public final NumberPath<Integer> tableNumber = createNumber("tableNumber", Integer.class);

    public QTableInfo(String variable) {
        super(TableInfo.class, forVariable(variable));
    }

    public QTableInfo(Path<? extends TableInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTableInfo(PathMetadata metadata) {
        super(TableInfo.class, metadata);
    }

}

