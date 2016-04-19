package com.org.coop.retail.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCashRegister is a Querydsl query type for CashRegister
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCashRegister extends EntityPathBase<CashRegister> {

    private static final long serialVersionUID = 1740659010L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCashRegister cashRegister = new QCashRegister("cashRegister");

    public final DatePath<java.util.Date> actionDate = createDate("actionDate", java.util.Date.class);

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final NumberPath<Integer> cashId = createNumber("cashId", Integer.class);

    public final DateTimePath<java.sql.Timestamp> createDate = createDateTime("createDate", java.sql.Timestamp.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath deleteInd = createString("deleteInd");

    public final StringPath deleteReason = createString("deleteReason");

    public final StringPath passingAuthInd = createString("passingAuthInd");

    public final StringPath passingAuthRemark = createString("passingAuthRemark");

    public final QTransactionPayment transactionPayment;

    public final DateTimePath<java.sql.Timestamp> updateDate = createDateTime("updateDate", java.sql.Timestamp.class);

    public final StringPath updateUser = createString("updateUser");

    public QCashRegister(String variable) {
        this(CashRegister.class, forVariable(variable), INITS);
    }

    public QCashRegister(Path<? extends CashRegister> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCashRegister(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCashRegister(PathMetadata<?> metadata, PathInits inits) {
        this(CashRegister.class, metadata, inits);
    }

    public QCashRegister(Class<? extends CashRegister> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.transactionPayment = inits.isInitialized("transactionPayment") ? new QTransactionPayment(forProperty("transactionPayment"), inits.get("transactionPayment")) : null;
    }

}

