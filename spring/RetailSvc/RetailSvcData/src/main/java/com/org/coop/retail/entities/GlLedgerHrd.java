package com.org.coop.retail.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gl_ledger_hrd database table.
 * 
 */
@Entity
@Table(name="gl_ledger_hrd")
@NamedQuery(name="GlLedgerHrd.findAll", query="SELECT g FROM GlLedgerHrd g")
@SQLDelete(sql="update gl_ledger_hrd set delete_ind='Y' where gl_tran_id = ?")
@Where(clause="delete_ind is NULL")
public class GlLedgerHrd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gl_tran_id")
	private int glTranId;

	@Temporal(TemporalType.DATE)
	@Column(name="action_date")
	private Date actionDate;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="delete_ind")
	private String deleteInd;

	@Column(name="delete_reason")
	private String deleteReason;

	private String fy;

	@Column(name="passing_auth_ind")
	private String passingAuthInd;

	@Column(name="passing_auth_remark")
	private String passingAuthRemark;

	@Column(name="tran_no")
	private String tranNo;

	@Column(name="tran_type")
	private String tranType;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user")
	private String updateUser;

	
	//bi-directional many-to-one association to BranchMaster
	@ManyToOne
	@JoinColumn(name="branch_id")
	private BranchMaster branchMaster;

	//bi-directional many-to-one association to RetailTransaction
	@OneToMany(mappedBy="glLedgerHrd", fetch = FetchType.LAZY, cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
	@Where(clause = "delete_ind is null")
	private List<RetailTransaction> retailTransactions;

	//bi-directional many-to-one association to TransactionPayment
	@OneToMany(mappedBy="glLedgerHrd", fetch = FetchType.LAZY, cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
	@Where(clause = "delete_ind is null")
	private List<TransactionPayment> transactionPayments;

	//bi-directional many-to-one association to GlLedgerDtl
	@OneToMany(mappedBy="glLedgerHrd", fetch = FetchType.LAZY, cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
	@Where(clause = "delete_ind is null")
	private List<GlLedgerDtl> glLedgerDtls;
	
	public GlLedgerHrd() {
	}

	public int getGlTranId() {
		return this.glTranId;
	}

	public void setGlTranId(int glTranId) {
		this.glTranId = glTranId;
	}

	public Date getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDeleteInd() {
		return this.deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public String getDeleteReason() {
		return this.deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public String getFy() {
		return this.fy;
	}

	public void setFy(String fy) {
		this.fy = fy;
	}

	public String getPassingAuthInd() {
		return this.passingAuthInd;
	}

	public void setPassingAuthInd(String passingAuthInd) {
		this.passingAuthInd = passingAuthInd;
	}

	public String getPassingAuthRemark() {
		return this.passingAuthRemark;
	}

	public void setPassingAuthRemark(String passingAuthRemark) {
		this.passingAuthRemark = passingAuthRemark;
	}

	public String getTranNo() {
		return this.tranNo;
	}

	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
	}

	public String getTranType() {
		return this.tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public BranchMaster getBranchMaster() {
		return this.branchMaster;
	}

	public void setBranchMaster(BranchMaster branchMaster) {
		this.branchMaster = branchMaster;
	}

	public List<RetailTransaction> getRetailTransactions() {
		return this.retailTransactions;
	}

	public void setRetailTransactions(List<RetailTransaction> retailTransactions) {
		this.retailTransactions = retailTransactions;
	}

	public RetailTransaction addRetailTransaction(RetailTransaction retailTransaction) {
		getRetailTransactions().add(retailTransaction);
		retailTransaction.setGlLedgerHrd(this);

		return retailTransaction;
	}

	public RetailTransaction removeRetailTransaction(RetailTransaction retailTransaction) {
		getRetailTransactions().remove(retailTransaction);
		retailTransaction.setGlLedgerHrd(null);

		return retailTransaction;
	}

	public List<TransactionPayment> getTransactionPayments() {
		return this.transactionPayments;
	}

	public void setTransactionPayments(List<TransactionPayment> transactionPayments) {
		this.transactionPayments = transactionPayments;
	}

	public TransactionPayment addTransactionPayment(TransactionPayment transactionPayment) {
		getTransactionPayments().add(transactionPayment);
		transactionPayment.setGlLedgerHrd(this);

		return transactionPayment;
	}

	public TransactionPayment removeTransactionPayment(TransactionPayment transactionPayment) {
		getTransactionPayments().remove(transactionPayment);
		transactionPayment.setGlLedgerHrd(null);

		return transactionPayment;
	}
	@PreUpdate
	
	public void updateTimeStamps() {
		long currentTime = System.currentTimeMillis();
	    updateDate = new Timestamp(currentTime);
	    if (createDate == null) {
	    	createDate = new Timestamp(currentTime);
	    }
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + glTranId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GlLedgerHrd other = (GlLedgerHrd) obj;
		if (glTranId != other.glTranId)
			return false;
		return true;
	}
	public List<GlLedgerDtl> getGlLedgerDtls() {
		return this.glLedgerDtls;
	}

	public void setGlLedgerDtls(List<GlLedgerDtl> glLedgerDtls) {
		this.glLedgerDtls = glLedgerDtls;
	}

	public GlLedgerDtl addGlLedgerDtl(GlLedgerDtl glLedgerDtl) {
		getGlLedgerDtls().add(glLedgerDtl);
		glLedgerDtl.setGlLedgerHrd(this);

		return glLedgerDtl;
	}

	public GlLedgerDtl removeGlLedgerDtl(GlLedgerDtl glLedgerDtl) {
		getGlLedgerDtls().remove(glLedgerDtl);
		glLedgerDtl.setGlLedgerHrd(null);

		return glLedgerDtl;
	}
}