package com.org.coop.junit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.coop.admin.service.AdminLoginService;
import com.org.coop.bs.config.BusinessServiceConfig;
import com.org.coop.customer.service.LoginService;
import com.org.coop.security.service.EmailService;
import com.org.coop.society.data.admin.entities.SecurityQuestion;
import com.org.coop.society.data.admin.repositories.SecurityQuestionRepository;
import com.org.coop.society.data.admin.repositories.UserAdminRepository;
import com.org.coop.society.data.transaction.config.DataAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataAppConfig.class, BusinessServiceConfig.class})
public class CooperativeServiceTest {
	private static final Logger logger = Logger.getLogger(CooperativeServiceTest.class);
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private AdminLoginService adminLoginService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserAdminRepository userRepository;
	
	@Autowired
	private SecurityQuestionRepository securityQuestionRepository;
	
	@Test
	public void matchSecQuestions() {
		Map<String, String> securityQuesionAndAnswer = new HashMap<String, String>();
		securityQuesionAndAnswer.put("What is the name of your best friend", "ashish");
		boolean isSecQuesMatch = adminLoginService.isSecurityQuestionMatched("ujan", securityQuesionAndAnswer);
		System.out.println("isSecQuesMatch: " + isSecQuesMatch);
		logger.info("isSecQuesMatch: " + isSecQuesMatch);
	}
	
//	@Test
	public void fetchStaff1() {
		List<String> role = adminLoginService.getRole("ashish");
		System.out.println(role);
		logger.info("Role: " + role);
	}
	
//	@Test
	public void emailTester() {
		emailService.sendEmail("asmo00b1@gmail.com", "coop@gmail.com", "Test mail from java app", "This is a test mail");
	}
}
