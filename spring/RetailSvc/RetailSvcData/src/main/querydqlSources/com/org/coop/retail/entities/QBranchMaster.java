package com.org.coop.retail.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBranchMaster is a Querydsl query type for BranchMaster
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBranchMaster extends EntityPathBase<BranchMaster> {

    private static final long serialVersionUID = -410572560L;

    public static final QBranchMaster branchMaster = new QBranchMaster("branchMaster");

    public final StringPath bankName = createString("bankName");

    public final NumberPath<Integer> branchId = createNumber("branchId", Integer.class);

    public final StringPath branchName = createString("branchName");

    public final StringPath contextRoot = createString("contextRoot");

    public final DateTimePath<java.sql.Timestamp> createDate = createDateTime("createDate", java.sql.Timestamp.class);

    public final StringPath createUser = createString("createUser");

    public final ListPath<RetailCustomerMaster, QRetailCustomerMaster> customerMasters = this.<RetailCustomerMaster, QRetailCustomerMaster>createList("customerMasters", RetailCustomerMaster.class, QRetailCustomerMaster.class, PathInits.DIRECT2);

    public final StringPath dbName = createString("dbName");

    public final StringPath deleteInd = createString("deleteInd");

    public final StringPath deleteReason = createString("deleteReason");

    public final StringPath email1 = createString("email1");

    public final StringPath email2 = createString("email2");

    public final DatePath<java.util.Date> endDate = createDate("endDate", java.util.Date.class);

    public final ListPath<FyClose, QFyClose> fyCloses = this.<FyClose, QFyClose>createList("fyCloses", FyClose.class, QFyClose.class, PathInits.DIRECT2);

    public final ListPath<GlLedgerHrd, QGlLedgerHrd> glLedgerHrds = this.<GlLedgerHrd, QGlLedgerHrd>createList("glLedgerHrds", GlLedgerHrd.class, QGlLedgerHrd.class, PathInits.DIRECT2);

    public final StringPath ifscCode = createString("ifscCode");

    public final ListPath<MaterialGroup, QMaterialGroup> materialGroups = this.<MaterialGroup, QMaterialGroup>createList("materialGroups", MaterialGroup.class, QMaterialGroup.class, PathInits.DIRECT2);

    public final ListPath<MaterialTranHrd, QMaterialTranHrd> materialTranHrds = this.<MaterialTranHrd, QMaterialTranHrd>createList("materialTranHrds", MaterialTranHrd.class, QMaterialTranHrd.class, PathInits.DIRECT2);

    public final StringPath micrCode = createString("micrCode");

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public final StringPath phone1 = createString("phone1");

    public final StringPath phone2 = createString("phone2");

    public final StringPath remarks = createString("remarks");

    public final ListPath<RetailCustomerMaster, QRetailCustomerMaster> retailCustomerMasters = this.<RetailCustomerMaster, QRetailCustomerMaster>createList("retailCustomerMasters", RetailCustomerMaster.class, QRetailCustomerMaster.class, PathInits.DIRECT2);

    public final ListPath<RetailDocument, QRetailDocument> retailDocuments = this.<RetailDocument, QRetailDocument>createList("retailDocuments", RetailDocument.class, QRetailDocument.class, PathInits.DIRECT2);

    public final ListPath<RetailRateChart, QRetailRateChart> retailRateCharts = this.<RetailRateChart, QRetailRateChart>createList("retailRateCharts", RetailRateChart.class, QRetailRateChart.class, PathInits.DIRECT2);

    public final DatePath<java.util.Date> startDate = createDate("startDate", java.util.Date.class);

    public final ListPath<StockEntry, QStockEntry> stockEntries = this.<StockEntry, QStockEntry>createList("stockEntries", StockEntry.class, QStockEntry.class, PathInits.DIRECT2);

    public final ListPath<TransactionPayment, QTransactionPayment> transactionPayments = this.<TransactionPayment, QTransactionPayment>createList("transactionPayments", TransactionPayment.class, QTransactionPayment.class, PathInits.DIRECT2);

    public final DateTimePath<java.sql.Timestamp> updateDate = createDateTime("updateDate", java.sql.Timestamp.class);

    public final StringPath updateUser = createString("updateUser");

    public final ListPath<VatRegNo, QVatRegNo> vatRegNos = this.<VatRegNo, QVatRegNo>createList("vatRegNos", VatRegNo.class, QVatRegNo.class, PathInits.DIRECT2);

    public final ListPath<VendorMaster, QVendorMaster> vendorMasters = this.<VendorMaster, QVendorMaster>createList("vendorMasters", VendorMaster.class, QVendorMaster.class, PathInits.DIRECT2);

    public QBranchMaster(String variable) {
        super(BranchMaster.class, forVariable(variable));
    }

    public QBranchMaster(Path<? extends BranchMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBranchMaster(PathMetadata<?> metadata) {
        super(BranchMaster.class, metadata);
    }

}

