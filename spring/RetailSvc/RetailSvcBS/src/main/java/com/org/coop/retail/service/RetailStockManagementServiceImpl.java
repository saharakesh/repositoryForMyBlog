package com.org.coop.retail.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.coop.canonical.beans.UIModel;
import com.org.coop.retail.servicehelper.PaymentServiceHelperImpl;
import com.org.coop.retail.servicehelper.RetailStockManagementServiceHelperImpl;

@Service
public class RetailStockManagementServiceImpl {

	private static final Logger log = Logger.getLogger(RetailStockManagementServiceImpl.class); 
	
	@Autowired
	private RetailStockManagementServiceHelperImpl retailStockManagementServiceHelperImpl;
	
	@Autowired
	private PaymentServiceHelperImpl paymentServiceHelperImpl;
	
	public UIModel getStockEntries(int branchId, int vendorId, int materialId, int pageNo, int recordsPerPage, String challanNo, String billNo, Date startDate, Date endDate) {
		return retailStockManagementServiceHelperImpl.getStockEntries(branchId, vendorId, materialId, pageNo, recordsPerPage, challanNo, billNo,startDate, endDate);
	}
	
	public UIModel saveStockEntries(UIModel uiModel) {
		uiModel = retailStockManagementServiceHelperImpl.saveStockEntries(uiModel);
		int branchId = uiModel.getBranchBean().getBranchId();
		if(uiModel.getBranchBean().getStockEntries() != null && uiModel.getBranchBean().getStockEntries().size() > 0) {
			String billNo = uiModel.getBranchBean().getStockEntries().get(0).getBillNo();
			if(billNo != null) {
				uiModel = retailStockManagementServiceHelperImpl.getStockEntries(branchId, 0, 0, 1, 10000, null, billNo, null, null);
			}
		}
		return uiModel;
	}
	
	public UIModel deleteStockEntries(UIModel uiModel) {
		uiModel = retailStockManagementServiceHelperImpl.deleteStockEntries(uiModel);
		return uiModel;
	}
	
	public UIModel saveStockSales(UIModel uiModel) {
		uiModel = retailStockManagementServiceHelperImpl.saveStockSales(uiModel);
		return uiModel;
	}
	
}
