package com.myjandcode.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails john = User.builder().username("jhon").password("{noop}test123").roles("EMPLOYEE").build();
		UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("MANAGER", "EMPLOYEE").build();
		UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("ADMIN", "EMPLOYEE").build();
		UserDetails rut = User.builder().username("rut").password("{noop}test123").roles("ADMIN","EMPLOYEE","MANAGER").build();
		
		return new InMemoryUserDetailsManager(john, mary, susan, rut);
	}

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
