package com.org.coop.retail.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSmsNotification is a Querydsl query type for SmsNotification
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSmsNotification extends EntityPathBase<SmsNotification> {

    private static final long serialVersionUID = 97057560L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSmsNotification smsNotification = new QSmsNotification("smsNotification");

    public final QBranchMaster branchMaster;

    public final DateTimePath<java.sql.Timestamp> createDate = createDateTime("createDate", java.sql.Timestamp.class);

    public final StringPath createUser = createString("createUser");

    public final QCustomer customer;

    public final QCustomerNotification customerNotification;

    public final StringPath deleteInd = createString("deleteInd");

    public final StringPath deleteReason = createString("deleteReason");

    public final StringPath email = createString("email");

    public final StringPath mobileNo = createString("mobileNo");

    public final StringPath passingAuthInd = createString("passingAuthInd");

    public final StringPath passingAuthRemark = createString("passingAuthRemark");

    public final NumberPath<Integer> smsId = createNumber("smsId", Integer.class);

    public final StringPath smsPurpose = createString("smsPurpose");

    public final StringPath smsSubject = createString("smsSubject");

    public final DateTimePath<java.sql.Timestamp> updateDate = createDateTime("updateDate", java.sql.Timestamp.class);

    public final StringPath updateUser = createString("updateUser");

    public QSmsNotification(String variable) {
        this(SmsNotification.class, forVariable(variable), INITS);
    }

    public QSmsNotification(Path<? extends SmsNotification> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSmsNotification(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSmsNotification(PathMetadata<?> metadata, PathInits inits) {
        this(SmsNotification.class, metadata, inits);
    }

    public QSmsNotification(Class<? extends SmsNotification> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.branchMaster = inits.isInitialized("branchMaster") ? new QBranchMaster(forProperty("branchMaster")) : null;
        this.customer = inits.isInitialized("customer") ? new QCustomer(forProperty("customer"), inits.get("customer")) : null;
        this.customerNotification = inits.isInitialized("customerNotification") ? new QCustomerNotification(forProperty("customerNotification"), inits.get("customerNotification")) : null;
    }

}

