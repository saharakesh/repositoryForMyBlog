package com.org.coop.admin.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.coop.admin.servicehelper.MasterDataSetupServiceHelperImpl;
import com.org.coop.canonical.master.beans.CountryMasterBean;
import com.org.coop.canonical.master.beans.MasterDataBean;
import com.org.coop.canonical.master.beans.ModuleMasterBean;

@Service
public class MasterDataSetupServiceImpl {

	private static final Logger log = Logger.getLogger(MasterDataSetupServiceImpl.class); 
	
	@Autowired
	private MasterDataSetupServiceHelperImpl masterDataSetupServiceHelperImpl;
	
	
	public MasterDataBean saveCountryStateDist(MasterDataBean masterDataBean) {
		masterDataBean = masterDataSetupServiceHelperImpl.saveCountryStateDist(masterDataBean);
		if(masterDataBean != null && StringUtils.isEmpty(masterDataBean.getErrorMsg())) {
			masterDataBean = getCountryStateDist(((CountryMasterBean)masterDataBean.getCountries().toArray()[0]).getCountryCode(), "", "");
		}
		return masterDataBean;
	}
	
	public MasterDataBean getCountryStateDist(String countryCode,String stateCode,String distCode) {
		return masterDataSetupServiceHelperImpl.getCountryStateDist(countryCode, stateCode, distCode);
	}
	
	public MasterDataBean deleteCountryStateDist(MasterDataBean masterDataBean, String countryCode,String stateCode,String distCode) {
		masterDataBean = masterDataSetupServiceHelperImpl.deleteCountryStateDist(masterDataBean, countryCode, stateCode, distCode);
		
		if(masterDataBean != null && StringUtils.isEmpty(masterDataBean.getErrorMsg())) {
			if(StringUtils.isNotEmpty(countryCode)) {
				masterDataBean = getCountryStateDist(countryCode, "", "");
			} else if(StringUtils.isNotEmpty(stateCode)) {
				masterDataBean = getCountryStateDist(countryCode, stateCode, "");
			} else if(StringUtils.isNotEmpty(distCode)) {
				masterDataBean = getCountryStateDist(countryCode, stateCode, distCode);
			}
		}
		return masterDataBean;
		
	}
	
	public MasterDataBean getModuleRulesAndPermissions(String moduleName) {
		return masterDataSetupServiceHelperImpl.getModuleRulesAndPermissions(moduleName);
	}
	
	public MasterDataBean saveModuleRulesAndPermissions(MasterDataBean masterDataBean) {
		masterDataBean = masterDataSetupServiceHelperImpl.saveModuleRulesAndPermissions(masterDataBean);
		
		if(masterDataBean != null && StringUtils.isEmpty(masterDataBean.getErrorMsg())) {
			masterDataBean = getModuleRulesAndPermissions(((ModuleMasterBean)masterDataBean.getModules().toArray()[0]).getModuleName());
		}
		return masterDataBean;
	}
	
	/**
	 * This method gets all active security questions (end_date = NULL) if noOfSecurityQuestion = 0.
	 * Otherwise it gets security questions by limits randomly. E.g. noOfSecurityQuestion = 3 then it retrieves 3 active 
	 * security questions randomly.
	 * @param noOfSecurityQuestion
	 * @return
	 */
	public MasterDataBean getSecurityQuestions(int noOfSecurityQuestion) {
		return masterDataSetupServiceHelperImpl.getSecurityQuestions(noOfSecurityQuestion);
	}
	
	public MasterDataBean saveSecurityQuestions(MasterDataBean masterDataBean) {
		
		masterDataBean = masterDataSetupServiceHelperImpl.saveSecurityQuestions(masterDataBean);
		
		if(masterDataBean != null && StringUtils.isEmpty(masterDataBean.getErrorMsg())) {
			masterDataBean = getSecurityQuestions(0);
		}
		return masterDataBean;
	}
	
	public MasterDataBean deleteSecurityQuestions(MasterDataBean masterDataBean) {
		
		masterDataBean = masterDataSetupServiceHelperImpl.deleteSecurityQuestions(masterDataBean);
		
		if(masterDataBean != null && StringUtils.isEmpty(masterDataBean.getErrorMsg())) {
			masterDataBean = getSecurityQuestions(0);
		}
		return masterDataBean;
	}
	
	public MasterDataBean getDropdown(int branchId, String category) {
		return masterDataSetupServiceHelperImpl.getDropdown(branchId, category);
	}
	
	public MasterDataBean saveDropdown(MasterDataBean masterDataBean) {
		return masterDataSetupServiceHelperImpl.saveDropdown(masterDataBean);
	}
	
}
