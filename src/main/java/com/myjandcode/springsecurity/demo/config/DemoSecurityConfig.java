package com.myjandcode.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {
	
	// add a reference to our security data source
	
	private DataSource securityDataSource;

	@Autowired
	public DemoSecurityConfig(DataSource theSecurityDataSource) {
		securityDataSource = theSecurityDataSource;
	}

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(securityDataSource);
	}
	
	//----------------------------------------------------------------

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(authorize -> authorize
				//.anyRequest().authenticated() // this line let any person roles can access page
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
				)

		// form that people need to put credentials if want to access page
				.formLogin(form -> form.loginPage("/showMyLoginPage")
						.loginProcessingUrl("/authenticateTheUser")
						.permitAll())
				
				.logout(loggout -> loggout
						.permitAll())
				
		// view jsp access denied when people don't have authorization for this type role
				.exceptionHandling(exception -> exception
						.accessDeniedPage("/access-denied"));

		return http.build();
	}

}
