/**
 * Every request will be intercepted at this class. preHandle() intercepts all requests before landing to the endpoing
 * And postHandle() handles POST Requests
 */
package com.org.coop.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.org.coop.admin.service.AdminLoginService;
import com.org.coop.canonical.beans.UserProfile;

@Component
public class RestEndpointInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = Logger.getLogger(RestEndpointInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        log.info("Request URL::" + request.getRequestURL().toString()
                + ":: Start Time=" + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        if(request.getRequestURL().toString().contains("/rest/")) {
        	UserProfile userProfile = (UserProfile)request.getSession().getAttribute("userProfile");
        	
//        	log.info("User " + userProfile.getUserName());
        	
        	if(userProfile != null && userProfile.isOtpEnabled()) {
        		if(userProfile.isOtpMatch()) {
	        		log.info("User has to be redirected to the dashboard");
	        	} else {
	        		request.getSession().invalidate();
	        		log.info("User session destroyed. User is redircted into login page");
	        	}
        	} else {
        		request.getSession().invalidate();
        		log.info("User session destroyed. User is redircted into login page");
        	}
        } 
        //if returned false, we need to make sure 'response' is sent
        return true;
    }
	
//	public void postHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		long startTime = (Long) request.getAttribute("startTime");
//		request.removeAttribute("startTime");
//
//		long endTime = System.currentTimeMillis();
//		modelAndView.addObject("totalTime", endTime - startTime);
//
//		log.info("Request Prcessing Time :: " + (endTime - startTime));
//	}
}
