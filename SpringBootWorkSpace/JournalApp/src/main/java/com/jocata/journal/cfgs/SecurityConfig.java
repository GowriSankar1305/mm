package com.jocata.journal.cfgs;

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
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(getPwdEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/","/login","/signup").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasAnyRole("ADMIN","USER").anyRequest().authenticated()
		.antMatchers("/**").denyAll().and()
		.formLogin().loginPage("/login").successHandler(successHandler)
		.failureUrl("/login?error")
		.and()
		.logout().logoutSuccessUrl("/login?logout")
		.clearAuthentication(true).deleteCookies("JSESSIONID")
		.invalidateHttpSession(true);
		
	}
	
	@Bean
	public BCryptPasswordEncoder getPwdEncoder()	{
		return new BCryptPasswordEncoder();
	}
}
