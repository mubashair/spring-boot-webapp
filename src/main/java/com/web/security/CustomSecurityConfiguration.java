package com.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
		
		return httpSecurity
				//.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(
				
				 authorize->authorize
				.requestMatchers("/testApiOne", "/**")
				.authenticated()
				.requestMatchers("/testApiTwo")
				.permitAll()
				.requestMatchers("testApiThree")
				.denyAll()
				
				).formLogin(Customizer.withDefaults()).build();
		
	}
	//creating multiple static users with the custom class spring security configurations
	@Bean
	InMemoryUserDetailsManager userDetailService() {
		UserDetails user1 = User.withUsername("java").password(passwordEncoder().encode("world")).build();
		UserDetails user2 = User.withUsername("meerab").password(passwordEncoder().encode("zubaida")).build();
		UserDetails user3 = User.withUsername("kau").password(passwordEncoder().encode("ali")).build();
		//InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(user1);
		
		//return userDetailsManager;
		return new InMemoryUserDetailsManager(user1, user2, user3);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		//BCryptPasswordEncoder passwordEncode = new BCryptPasswordEncoder();
		//return passwordEncode;
		return new BCryptPasswordEncoder();
	}
}