package com.org.coop.admin.ws;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.coop.admin.service.MasterDataSetupServiceImpl;
import com.org.coop.canonical.master.beans.MasterDataBean;
import com.org.coop.canonical.master.beans.ModuleMasterBean;

@RestController
@RequestMapping("/rest")
public class MasterDataSetupWSImpl {
	
	private static final Logger log = Logger.getLogger(MasterDataSetupWSImpl.class); 
	
	@Autowired
	private MasterDataSetupServiceImpl masterDataSetupServiceImpl;
	
	/**
	 * Country/State/District can be saved together or individually
	 * @param masterDataBean
	 * @return
	 */
	@RequestMapping(value = "/saveCountryStateDist", method = RequestMethod.POST, headers="Accept=application/json",produces="application/json",consumes="application/json")
	public MasterDataBean saveCountryStateDist(@RequestBody MasterDataBean masterDataBean) {
		try {
			masterDataBean = masterDataSetupServiceImpl.saveCountryStateDist(masterDataBean);
		} catch (Exception e) {
			log.error("Error Creating/Updating country/state/district", e);
			masterDataBean.setErrorMsg("Error Creating/Updating country/state/district");
		}
		return masterDataBean;
	}
	
	@RequestMapping(value = "/getCountryStateDist", method = RequestMethod.GET, headers="Accept=application/json",produces="application/json")
	public MasterDataBean getCountryStateDist(@RequestParam(value = "countryCode",required = true,defaultValue = "") String countryCode,
			@RequestParam(value = "stateCode",required = true,defaultValue = "") String stateCode,
			@RequestParam(value = "distCode",required = true,defaultValue = "") String distCode) {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataSetupServiceImpl.getCountryStateDist(countryCode,stateCode,distCode);
		} catch (Exception e) {
			log.error("Error Retrieving Country by Country Id", e);
			masterData.setErrorMsg("Error Retrieving Country by Country Id: " + countryCode);
		}
		return masterData;
	}
	
	@RequestMapping(value = "/deleteCountryStateDist", method = RequestMethod.DELETE, headers="Accept=application/json",produces="application/json",consumes="application/json")
	public MasterDataBean deleteCountryStateDist(@RequestBody MasterDataBean masterDataBean,
			@RequestParam(value = "countryCode",required = true,defaultValue = "") String countryCode,
			@RequestParam(value = "stateCode",required = true,defaultValue = "") String stateCode,
			@RequestParam(value = "distCode",required = true,defaultValue = "") String distCode) {
		try {
			masterDataBean = masterDataSetupServiceImpl.deleteCountryStateDist(masterDataBean, countryCode, stateCode, distCode);
			
		} catch (Exception e) {
			log.error("Error while deleting country/state/district", e);
			masterDataBean.setErrorMsg("Error while deleting country/state/district");
		}
		return masterDataBean;
	}
	
	@RequestMapping(value = "/getModuleRulesAndPermissions", method = RequestMethod.GET, headers="Accept=application/json",produces="application/json")
	public MasterDataBean getModuleRulesAndPermissions(@RequestParam(value = "moduleName",required = true,defaultValue = "") String moduleName) {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataSetupServiceImpl.getModuleRulesAndPermissions(moduleName);
		} catch (Exception e) {
			log.error("Error Retrieving Module details for module Name", e);
			masterData.setErrorMsg("Error Retrieving Module details for module Name: " + moduleName);
		}
		return masterData;
	}
	
	@RequestMapping(value = "/saveModuleRulesAndPermissions", method = RequestMethod.POST, headers="Accept=application/json",produces="application/json")
	public MasterDataBean saveModuleRulesAndPermissions(@RequestBody MasterDataBean masterDataBean) {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataSetupServiceImpl.saveModuleRulesAndPermissions(masterDataBean);
		} catch (Exception e) {
			log.error("Error Retrieving Module details for module:" + ((ModuleMasterBean)masterDataBean.getModules().toArray()[0]).getModuleName() , e);
			masterData.setErrorMsg("Error saving Module details for module Name: " + ((ModuleMasterBean)masterDataBean.getModules().toArray()[0]).getModuleName());
		}
		return masterData;
	}
	
	@RequestMapping(value = "/getSecurityQuestions", method = RequestMethod.GET, headers="Accept=application/json",produces="application/json")
	public MasterDataBean getSecurityQuestions(@RequestParam(value = "noOfSecurityQuestion",required = true,defaultValue = "0") int noOfSecurityQuestion) {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataSetupServiceImpl.getSecurityQuestions(noOfSecurityQuestion);
		} catch (Exception e) {
			log.error("Error Retrieving Security questions:" , e);
			masterData.setErrorMsg("Error Retrieving the Security questions");
		}
		return masterData;
	}
	
	@RequestMapping(value = "/saveSecurityQuestions", method = RequestMethod.POST, headers="Accept=application/json",produces="application/json")
	public MasterDataBean saveSecurityQuestions(@RequestBody MasterDataBean masterDataBean) {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataSetupServiceImpl.saveSecurityQuestions(masterDataBean);
		} catch (Exception e) {
			log.error("Error while saving Security questions" , e);
			masterData.setErrorMsg("Error while saving Security questions ");
		}
		return masterData;
	}
	
	@RequestMapping(value = "/deleteSecurityQuestions", method = RequestMethod.DELETE, headers="Accept=application/json",produces="application/json")
	public MasterDataBean deleteSecurityQuestions(@RequestBody MasterDataBean masterDataBean) {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataSetupServiceImpl.deleteSecurityQuestions(masterDataBean);
		} catch (Exception e) {
			log.error("Error while deleting Security questions" , e);
			masterData.setErrorMsg("Error while deleting Security questions ");
		}
		return masterData;
	}
	
	@RequestMapping(value = "/getDropdown", method = RequestMethod.GET, headers="Accept=application/json",produces="application/json")
	public MasterDataBean getDropdown(@RequestParam(value = "branchId",required = false,defaultValue = "0") int branchId,
										@RequestParam(value = "category",required = false,defaultValue = "") String category) {
		return masterDataSetupServiceImpl.getDropdown(branchId, category);
	}
	
	@RequestMapping(value = "/saveDropdown", method = RequestMethod.POST, headers="Accept=application/json",produces="application/json", consumes="application/json")
	public MasterDataBean saveDropdown(@RequestBody MasterDataBean masterDataBean) {
		return masterDataSetupServiceImpl.saveDropdown(masterDataBean);
	}
}
