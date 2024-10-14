package org.freecode.demo.springboot3restapisecurity;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringBoot3RestApiSecurityConfiguration {

	// password format eg {noop}password means plain text, {bcrypt}**##...
	// add security configuration - eg In memory, JDBC etc and define users and roles
	
//	@Bean 
//	/**
//	 * disable when using plain test password
//	 */
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
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
//		UserDetails alex = User.builder()
//				.username("alex")
//				.password(passwordEncoder().encode("test456")) // password encoded to {bcrypt}$2a$10$C6...
//				.roles("READER", "CONTRIBUTOR", "ADMIN")
//				.build();
//		//System.out.println("ALEX PASS: " + userDetailsManager().loadUserByUsername("alex").getPassword());
//		
//		return new InMemoryUserDetailsManager(jon, shirley, alex);
//	}
	
//	@Bean
//	/**
//	 * JDBC authentication and authorization using default tables
//	 * @return
//	 */
//	public UserDetailsManager userDetailsManager(DataSource ds) {
//		return new JdbcUserDetailsManager(ds);
//	}
	
	@Bean
	/**
	 * JDBC authentication and authorization with custom tables and fields
	 * @param ds
	 * @return
	 */
	public UserDetailsManager userDetailsManager(DataSource ds) {
		JdbcUserDetailsManager usrDetailsMgr = new JdbcUserDetailsManager(ds);
		
		//usrDetailsMgr.setUsersByUsernameQuery("SELECT user_id, user_pass, is_active FROM t_user WHERE user_id=?"); // is_active defined with the default data type
		usrDetailsMgr.setUsersByUsernameQuery("SELECT user_id, user_pass, (CASE WHEN is_active = 'ACTIVE' THEN 1 ELSE 0 END) FROM t_user WHERE user_id=?"); // is_active defined with a different type and needs conversion
		usrDetailsMgr.setAuthoritiesByUsernameQuery("SELECT user_id, user_role FROM t_role WHERE user_id=?");
		
		return usrDetailsMgr;
	}
	
	@Bean
	/**
	 * 
	 * @param httpsec
	 * @return
	 * @throws Exception
	 */
	public SecurityFilterChain filterChain(HttpSecurity httpsec) throws Exception {
		// READER can view, CONTRIBUTOR can create and update, and only ADMIN can delete 
		httpsec.authorizeHttpRequests(configurer -> configurer
				.requestMatchers(HttpMethod.GET, "/api/articles").hasRole("READER")
				.requestMatchers(HttpMethod.GET, "/datarest/groups").hasRole("READER")
				.requestMatchers(HttpMethod.GET, "/api/articles/**").hasRole("READER")
				.requestMatchers(HttpMethod.GET, "/datarest/groups/**").hasRole("READER")
				.requestMatchers(HttpMethod.POST, "/api/articles").hasRole("CONTRIBUTOR")
				.requestMatchers(HttpMethod.POST, "/datarest/groups").hasRole("CONTRIBUTOR")
				.requestMatchers(HttpMethod.PUT, "/api/articles").hasRole("CONTRIBUTOR")
				.requestMatchers(HttpMethod.PUT, "/datarest/groups/**").hasRole("CONTRIBUTOR") // for DATA REST
				.requestMatchers(HttpMethod.DELETE, "/api/articles/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/datarest/groups/**").hasRole("ADMIN")
				);
				
		// use HTTP basic authentication
		httpsec.httpBasic(Customizer.withDefaults());
		
		// disable cross-site request forgery because it is recommended to web applications, and RESTful werb services are okay
//		Customizer<CsrfConfigurer<HttpSecurity>> csrfCustomizer = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//			
//			@Override
//			public void customize(CsrfConfigurer<HttpSecurity> t) {
//				t.disable();
//			}
//		};
//		httpsec.csrf(csrfCustomizer);
		httpsec.csrf(csrf -> csrf.disable());
				
		return httpsec.build();
	}
}
