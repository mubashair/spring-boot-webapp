package com.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
@Configuration
public class CustomSecurityConfiguration {
	@Bean
	DefaultSecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		//httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
		httpSecurity.authorizeHttpRequests().requestMatchers("/testApiOne").authenticated();
		httpSecurity.authorizeHttpRequests().requestMatchers("/testApiTwo").permitAll();
		httpSecurity.authorizeHttpRequests().requestMatchers("/").permitAll();
		httpSecurity.formLogin();
		return httpSecurity.build();
		//mubashar
	}
}