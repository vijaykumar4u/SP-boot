package com.vijay.spring_security.confi_gure;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@EnableWebSecurity
public class Scurity_Configuration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;// for jdbc authentication

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

// IN MEMORY AUTHENTICATION		
//		auth.inMemoryAuthentication().withUser("fool").password("fool").roles("USER").and().withUser("Admin")
//				.password("Admin").roles("ADMIN");
//		auth.jdbcAuthentication()
//		    .dataSource(dataSource)
//		    .withDefaultSchema()   // setting up default schema provided by spring security
//		    .withUser(
//				User.withUsername("user")
//					.password("user")
//					.roles("USER")
//
//		).withUser(
//
//				User.withUsername("admin").password("admin").roles("ADMIN")
//
//		);
		// JDBC authentication
//		auth.jdbcAuthentication()
//		    .dataSource(dataSource);//it looks for the default schema in the datasource it wont create schema
// the schema would be different everywhere they are not the same in that case use below process

		auth.jdbcAuthentication()
		        .dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled" 
		                + " from users" 
						+ " where username=?")
				.authoritiesByUsernameQuery("select username, authority" +
						" from authorities" 
						+ " where username=?");

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/test/admin").hasRole("ADMIN").antMatchers("/test/user")
				.hasAnyRole("USER", "ADMIN").antMatchers("/", "/h2-console/**").permitAll().and().formLogin();
	}

}
