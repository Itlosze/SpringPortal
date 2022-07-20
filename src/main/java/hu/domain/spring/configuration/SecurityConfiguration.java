package hu.domain.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

// Users and password in memory
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder authBuilder) throws Exception{
		authBuilder.inMemoryAuthentication()
				.withUser("admin")
				.password("{noop}pass")
				.roles("ADMIN");
	}
	
// Authorization
	@Override
	protected void configure(HttpSecurity httpSec) throws Exception {
		httpSec.authorizeRequests()
		.antMatchers("/db/**").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/").hasRole("ADMIN").anyRequest().authenticated()
	.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
	.and()
		.logout()
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}
}
