package com.ticketbooking;
/*
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ticketbooking.service.MyDBAuthenticationService;
 

// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
   @Autowired
   MyDBAuthenticationService myDBAauthenticationService;
 
   @Override
   protected void configure(HttpSecurity http) throws Exception {
 
//       http.csrf().disable();
 
       // The pages requires login as EMPLOYEE or MANAGER.
       // If no login, it will redirect to /login page.
//       http.authorizeRequests().antMatchers("/products","/users")//
//               .access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')");
       
       // For ADMIN only.
       http.authorizeRequests().antMatchers("/cp/**").access("hasAuthority('ADMIN')"); 
       
       // For USER only.
       //http.authorizeRequests().antMatchers("/cart/**").access("hasAuthority('USER')"); 
       
    // For LOGIN only.
       http.authorizeRequests().antMatchers("/**").permitAll();
 
       // When the user has logged in as XX.
       // But access a page that requires role YY,
       // AccessDeniedException will throw.
      http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/access-denied");
 
       // Config for Login Form
       http.authorizeRequests().and().formLogin()//
               // Submit URL of login page.
               //.loginProcessingUrl("/j_spring_security_check") // Submit URL
		       .defaultSuccessUrl("/")
		       .loginPage("/login").permitAll()//
               ///
               //.failureUrl("/login?error=true")//
               // Config for Logout Page
               // (Go to home page).
               .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index");
 
   }
   
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
       // For User in database.
       auth.userDetailsService(myDBAauthenticationService);
       
       //auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
 
   }
   
   
   
	// JDBC Authentication
	// Provides default queries
	// – SELECT username, password, enabled FROM users WHERE username = ?
	// – SELECT username, authority FROM authorities WHERE username = ?
	// We can customize the default queries by using following methods
	// usersByUsernameQuery()
	// authoritiesByUsernameQuery()
	// groupAuthoritiesByUsername()
//   @Autowired
//   DataSource datasource;
//   
//   @Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication()
//				.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
//				.authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
//				.dataSource((javax.sql.DataSource) datasource);
//	}
}


*/