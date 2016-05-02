package com.org.coop.retail.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the stock_entry database table.
 * 
 */
@Entity
@Table(name="stock_entry")
@NamedQuery(name="StockEntry.findAll", query="SELECT s FROM StockEntry s")
@SQLDelete(sql="update stock_entry set delete_ind='Y' where stock_id = ?")
@Where(clause="delete_ind is NULL")
public class StockEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="stock_id")
	private int stockId;
	
	@Column(name="parent_stock_id")
	private int parentStockId;

	private String batch;

	@Column(name="bill_no")
	private String billNo;
	
	@Column(name="challan_no")
	private String challanNo;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="delete_ind")
	private String deleteInd;

	@Column(name="delete_reason")
	private String deleteReason;

	@Temporal(TemporalType.DATE)
	@Column(name="challan_date")
	private Date challanDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="action_date")
	private Date actionDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="bill_date")
	private Date billDate;

	@Column(name="entry_type")
	private String entryType;

	@Column(name="mfg_date")
	private Timestamp mfgDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="exp_date")
	private Date expDate;
	
	@Column(name="passing_auth_ind")
	private String passingAuthInd;

	@Column(name="passing_auth_remark")
	private String passingAuthRemark;

	@Column(name="purchase_price")
	private BigDecimal purchasePrice;

	private BigDecimal qty;

	@Column(name="qty_under_booking")
	private BigDecimal qtyUnderBooking;
	
	@Column(name="qty_under_booking_time")
	private Timestamp qtyUnderBookingTime;
	
	@Column(name="available_qty")
	private BigDecimal availableQty;
	
	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to BranchMaster
	@ManyToOne
	@JoinColumn(name="branch_id")
	private BranchMaster branchMaster;

	//bi-directional many-to-one association to MaterialMaster
	@ManyToOne
	@JoinColumn(name="material_id")
	private MaterialMaster materialMaster;

	//bi-directional many-to-one association to VendorMaster
	@ManyToOne
	@JoinColumn(name="vendor_id")
	private VendorMaster vendorMaster;

	//bi-directional many-to-one association to StockReturn
	@OneToMany(mappedBy="stockEntry", fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@Where(clause="delete_ind is NULL")
	private List<StockReturn> stockReturns;
	
	//bi-directional many-to-one association to MaterialTranDtl
	@OneToMany(mappedBy="stockEntry", fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@Where(clause="delete_ind is NULL")
	private List<MaterialTranDtl> materialTranDtls;

	public StockEntry() {
	}

	public int getStockId() {
		return this.stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
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


	public Date getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
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

	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
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

	public MaterialMaster getMaterialMaster() {
		return this.materialMaster;
	}

	public void setMaterialMaster(MaterialMaster materialMaster) {
		this.materialMaster = materialMaster;
	}

	public VendorMaster getVendorMaster() {
		return this.vendorMaster;
	}

	public void setVendorMaster(VendorMaster vendorMaster) {
		this.vendorMaster = vendorMaster;
	}

	public List<StockReturn> getStockReturns() {
		return this.stockReturns;
	}

	public void setStockReturns(List<StockReturn> stockReturns) {
		this.stockReturns = stockReturns;
	}

	public StockReturn addStockReturn(StockReturn stockReturn) {
		getStockReturns().add(stockReturn);
		stockReturn.setStockEntry(this);

		return stockReturn;
	}

	public StockReturn removeStockReturn(StockReturn stockReturn) {
		getStockReturns().remove(stockReturn);
		stockReturn.setStockEntry(null);

		return stockReturn;
	}

	public BigDecimal getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(BigDecimal availableQty) {
		this.availableQty = availableQty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stockId;
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
		StockEntry other = (StockEntry) obj;
		if (stockId != other.stockId)
			return false;
		return true;
	}

	@PreUpdate
	
	public void updateTimeStamps() {
	    updateDate = new Timestamp(System.currentTimeMillis());
	    if (createDate == null) {
	    	createDate = new Timestamp(System.currentTimeMillis());
	    }
	}

	public List<MaterialTranDtl> getMaterialTranDtls() {
		return materialTranDtls;
	}

	public void setMaterialTranDtls(List<MaterialTranDtl> materialTranDtls) {
		this.materialTranDtls = materialTranDtls;
	}
	public MaterialTranDtl addMaterialTranDtl(MaterialTranDtl materialTranDtl) {
		getMaterialTranDtls().add(materialTranDtl);
		materialTranDtl.setStockEntry(this);

		return materialTranDtl;
	}

	public MaterialTranDtl removeMaterialTranDtl(MaterialTranDtl materialTranDtl) {
		getMaterialTranDtls().remove(materialTranDtl);
		materialTranDtl.setStockEntry(null);

		return materialTranDtl;
	}

	public int getParentStockId() {
		return parentStockId;
	}

	public void setParentStockId(int parentStockId) {
		this.parentStockId = parentStockId;
	}

	public Timestamp getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Timestamp mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public BigDecimal getQtyUnderBooking() {
		return qtyUnderBooking;
	}

	public void setQtyUnderBooking(BigDecimal qtyUnderBooking) {
		this.qtyUnderBooking = qtyUnderBooking;
	}

	public Timestamp getQtyUnderBookingTime() {
		return qtyUnderBookingTime;
	}

	public void setQtyUnderBookingTime(Timestamp qtyUnderBookingTime) {
		this.qtyUnderBookingTime = qtyUnderBookingTime;
	}
}