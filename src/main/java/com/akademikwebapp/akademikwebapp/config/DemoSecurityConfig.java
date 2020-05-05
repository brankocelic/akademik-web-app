package com.akademikwebapp.akademikwebapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(securityDataSource);

	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/lista-jela").hasAnyRole("MANAGER", "ADMIN", "EMPLOYEE")
				.antMatchers("/update/**").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers("/admin/**","/delete/**" , "/userses/**" , "/authorities/**").hasRole("ADMIN")
				.and()
				.formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/AuthenticateTheUser")
				.permitAll().and()
				.logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");

	}

}
