package com.demo.springbootrest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

@Configuration
@EnableWebSecurity
public class LDAPSecurityConfig extends WebSecurityConfigurerAdapter {
	
@Autowired
private UserDetailsService userdetailsservice;

@Autowired
AuthenticationEntryPoint authenticationEntryPoint;

@Override
public void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.ldapAuthentication()
			.userDnPatterns("uid={0},ou=people")
			.groupSearchBase("ou=groups")
			.contextSource()
				.url("ldap://localhost:10389/dc=springframework,dc=org")
				.and()
			.passwordCompare()
				.passwordEncoder(new LdapShaPasswordEncoder())
				.passwordAttribute("userPassword");
}



	// Authentication : User --> Roles
	/*protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance()).withUser("user1").password("secret1")
				.roles("USER").and().withUser("admin1").password("secret1")
				.roles("USER", "ADMIN");
	}*/

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
			.anyRequest().fullyAuthenticated().and().formLogin();
			//exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		}
	
	
	
}