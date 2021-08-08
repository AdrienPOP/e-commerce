package com.ap_commerce.engine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ap_commerce.engine.authentication.AppAuthProvider;
import com.ap_commerce.engine.authentication.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService userDetailsService;
	
	/**
	 * {@link https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-form}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/", "/home", "/category", "/allCategory", "/Cart", "/addArticleOnCart", "/register", "/logout	").permitAll()
				.antMatchers(HttpMethod.POST, "/login", "/registerUser").permitAll()
				.antMatchers("/css/*", "/js/**", "/ressources/*").permitAll()
//				.antMatchers("/account").hasRole("USER")
//				.antMatchers(HttpMethod.GET, "/addCategory", "/addArticle").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.authenticationProvider(getProvider())
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home")
                .deleteCookies("JSESSIONID")
//                .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .permitAll();
	}
	


	/**
	 * {@link https://docs.spring.io/spring-security/site/docs/current/reference/html5/#authentication-password-storage-bcrypt}
	 * @return
	 */
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
	
	@Bean
	public AuthenticationProvider getProvider() {
		AppAuthProvider appAuthProvider = new AppAuthProvider();
		appAuthProvider.setUserDetailsService(userDetailsService());
		return appAuthProvider;
	}
}