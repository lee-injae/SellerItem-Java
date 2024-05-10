package com.blit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.blit.servicees.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) 
			throws Exception {
			return http
					.csrf(csrf -> csrf.disable())
					.cors(cors -> Customizer.withDefaults())
					.authorizeHttpRequests(
							c -> {c.requestMatchers(HttpMethod.GET,
									"api/v1/item/*").hasAnyRole("ADMIN", "USER")
							.requestMatchers(HttpMethod.POST, 
									"api/v1/item/*").hasAnyRole("ADMIN", "USER")
							.requestMatchers(HttpMethod.DELETE, 
									"api/v1/item/*").hasAnyRole("ADMIN", "USER")
							.requestMatchers(HttpMethod.PUT, 
									"api/v1/item/*").hasAnyRole("ADMIN", "USER")
							.anyRequest().authenticated();						
							})
					.httpBasic(Customizer.withDefaults())
					.build();
	}
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
		throws Exception{
				auth.userDetailsService(userService)
				.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPaswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
