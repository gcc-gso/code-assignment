/**
 * 
 */
package org.gso.codeassignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author AhmedSalem
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("Ahmad").password("{noop}1234").roles("USER", "ADMIN").and()
				.withUser("Belal").password("{noop}1515").roles("USER");

	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**").permitAll()
				.antMatchers("/todolist/adminList").hasRole("ADMIN")
				//.antMatchers("/todo/**/all").hasRole("ADMIN")
				.antMatchers("/todo/**").hasRole("USER")
				.antMatchers("/todolist", "/todolist/show/*", "/console/*", "/h2-console/**").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/todolist").permitAll().and()
				.logout().logoutSuccessUrl("/").permitAll().and().exceptionHandling().accessDeniedPage("/unauthorized");

		http.csrf().disable();
		http.headers().frameOptions().disable();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**");
	}

}