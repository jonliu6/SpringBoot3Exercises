package org.freecode.demo.springboot3mvcsecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Springboot3mvcsecurityConfiguration {

	@Bean
	/*
	 * set up custom login page and logout
	 */
	public SecurityFilterChain filterChain(HttpSecurity hs) throws Exception {
		
		hs.authorizeHttpRequests(configurer -> 
		      configurer
		      .requestMatchers(HttpMethod.GET, "/home").hasRole("READER") // allow READER GET request to /home
		      .requestMatchers(HttpMethod.GET, "/contribution/**").hasRole("CONTRIBUTOR") // allow CONTRIBUTOR GET request to /contribution
		      .requestMatchers(HttpMethod.GET, "/administration/**").hasRole("ADMIN") // allow ADMIN GET request to /administration
		      .anyRequest().authenticated()
		    ).formLogin(form ->
		        form.loginPage("/showCustomLoginPage") // Controller mapping to open the custom login page
		    		.loginProcessingUrl("/authenticateTheUser") // POST action on the custom login page for processing the authentication based on the user input
		    		.permitAll()
		    ).logout(logout -> logout.clearAuthentication(true)
		    		.invalidateHttpSession(true)
		    		.permitAll()
		    ).exceptionHandling(configurer ->
		        configurer.accessDeniedPage("/access-denied") // redirection access error to access-denied page
		    );
		
		return hs.build();
	}
	
	@Bean
	/**
	 * JDBC authentication and authorization with custom tables and fields
	 * Note: DataSource requires dependency - spring-boot-starter-data-jpa and DB driver
	 * @param ds
	 * @return
	 */
	public UserDetailsManager userDetailsManager(DataSource ds) {
		JdbcUserDetailsManager usrDetailsMgr = new JdbcUserDetailsManager(ds);
		
		// query to get user by user name/id
		/**
		 * table structure
		 * user_id VARCHAR(50) NOT NULL PRIMARY KEY
		 * user_pass VARCHAR(100) NOT NULL
		 * is_active VARCHAR(10) NOT NULL -- need to convert to the default type - TINYINT
		 */
		usrDetailsMgr.setUsersByUsernameQuery("SELECT user_id, user_pass, (CASE WHEN is_active = 'ACTIVE' THEN 1 ELSE 0 END) FROM t_user WHERE user_id=?"); // is_active defined with a different type and needs conversion
		
		// query to get authorities by user name/id
		/**
		 * table structure
		 * user_id VARCHAR(50) NOT NULL
		 * user_role VARCHAR(50) NOT NULL
		 */
		usrDetailsMgr.setAuthoritiesByUsernameQuery("SELECT user_id, user_role FROM t_role WHERE user_id=?");
		
		return usrDetailsMgr;
	}

	
//	@Bean
//	/**
//	 * hard-coded authentication, not to use in production
//	 * @return
//	 */
//	public InMemoryUserDetailsManager userDetailsManager() {
//		
//		// hard-code few users with roles of reader, contributor, and admin
//		UserDetails jon = User.builder()
//				.username("jon")
//				.password("{noop}test123")
//				.roles("READER")
//				.build();
//		UserDetails shirley = User.builder()
//				.username("shirley")
//				.password("{noop}test123")
//				.roles("READER", "CONTRIBUTOR")
//				.build();
//		UserDetails tyler = User.builder()
//				.username("tyler")
//				.password("{noop}test456")
//				.roles("READER", "CONTRIBUTOR", "ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(jon, shirley, tyler);
//	}

}
