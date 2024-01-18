package com.evently.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigurationSecurityApplication {

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(
                        authorize ->
                                authorize.requestMatchers(HttpMethod.POST, "/inscription").permitAll()
                                        .anyRequest().authenticated()
                ).build();
	}
}

