package com.flexshose.flexshoesbackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

	private final String[] PUBLIC_ENDPOINT = { "api/public/**", "api/account/register", "api/auth/**", "/api/customer/add" };


	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
				requests -> requests.requestMatchers(PUBLIC_ENDPOINT).permitAll()
				.requestMatchers("api/auth/logout").permitAll()
				.anyRequest().permitAll());
		
		httpSecurity.oauth2ResourceServer(
				oauth2 -> oauth2.jwt(
						jwt -> jwt.decoder(customJWTDecoder())
						.jwtAuthenticationConverter(authenticationConverter())
						)
				.authenticationEntryPoint(new MyAuthenticationEntryPoint())
				);
				

		return httpSecurity.build();
	}
	@Bean
	JwtAuthenticationConverter authenticationConverter() {
		JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
		converter.setAuthorityPrefix("ROLE_");
		converter.setAuthoritiesClaimName("role");
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(converter);
		return jwtAuthenticationConverter;
	}
	
	@Bean
	CustomJWTDecoder customJWTDecoder() {
		return new CustomJWTDecoder();
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
