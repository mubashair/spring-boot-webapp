package com.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
@Configuration
public class CustomSecurityConfiguration {
	@Bean
	DefaultSecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		//httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
		/*httpSecurity.authorizeHttpRequests().requestMatchers("/testApiOne").authenticated();
		httpSecurity.authorizeHttpRequests().requestMatchers("/testApiTwo", "/userRegister").permitAll();
		httpSecurity.authorizeHttpRequests().requestMatchers("/").permitAll();
		httpSecurity.formLogin();
		return httpSecurity.build();*/
		//mubashar
		
		return httpSecurity.authorizeHttpRequests(
				authorize->authorize
				.requestMatchers("/testApiOne")
				.authenticated()
				.requestMatchers("/testApiTwo")
				.permitAll()
				.requestMatchers("testApiThree")
				.denyAll()
				
				).formLogin(Customizer.withDefaults()).build();
		
	}
}