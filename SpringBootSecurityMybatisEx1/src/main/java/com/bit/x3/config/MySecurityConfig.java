package com.bit.x3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
     // 교재 605페이지
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("configure(AuthenticationManagerBuilder auth)");
		System.out.println("userDetailsService : "+userDetailsService);
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.authorizeRequests()
				.antMatchers("/","/memberNew","/logout").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/member/**").hasRole("MEMBER")
				//.anyRequest().authenticated()
				.antMatchers("/**").permitAll()
		.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/loginSucces")
				.failureUrl("/loginfail")
			.permitAll()
		.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/logoutSucces")
				.invalidateHttpSession(true)
		.and()
			.exceptionHandling()
				.accessDeniedPage("/denied");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new   BCryptPasswordEncoder() ;
	}
	
	
}












