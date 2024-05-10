//package com.blit.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) 
//			throws Exception {
//			http
//				.cors(cors -> Customizer.withDefaults())
//				.csrf(csrf -> csrf.disable())
//				.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest())
//				.authorizeHttpRequests()
//				.requestMatchers(HttpMethod.POST, "/api/v1/item")
//				.hasAnyRole("ADMIN", "USER")
//				.requestMatchers(HttpMethod.DELETE)
//				.hasRole("ADMIN")
//				.anyRequest().authenticated()
//				.and()
//				.httpBasic()
//				.and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//				
//			
//			return http.build();
//	}
//	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(bCryptPaswordEncoder().encode("adminPass"))
//				.roles("ADMIN")
//				.build();
//		UserDetails user = User.builder()
//				.username("user")
//				.password(bCryptPaswordEncoder().encode("userPass"))
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(admin, user);
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder bCryptPaswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	
//}
