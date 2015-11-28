package com.org.coop.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.org.coop.authentication.CustomAuthenticationProvider;
import com.org.coop.authentication.PostAuthenticationHandler;

@Configuration
@EnableWebSecurity(debug=false)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;
	
	@Autowired
	private CustomAuthenticationProvider authenticationProvider;

	@Autowired
	private PostAuthenticationHandler postAuthenticationHandler;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
//        auth.inMemoryAuthentication().withUser(userName).password("root123").roles(loginService.getRole("ashish", "ashish").toUpperCase());
//        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");//dba have two roles.
    	try {
    		auth.userDetailsService(customUserDetailsService);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.authorizeRequests()
//        .antMatchers("/", "/home").permitAll()
        .antMatchers("/rest/**").access("hasRole('USER') and hasRole('ADMIN')")
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
//        .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
        .and().formLogin()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
      
      http.formLogin().defaultSuccessUrl("/otp", true);
      /**
       * BCryptPasswordEncoder hash the password (NOT encrypt). Hashing is always one way operation
       * Encryption is possible but decryption is not possible using any hashing algorithm
       */
      authenticationProvider.setPasswordEncoder(getEncoder());
      http.authenticationProvider(authenticationProvider);
    }
    
    @Bean
    public BCryptPasswordEncoder getEncoder() {
    	BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(11);
    	return bCrypt;
    }
}