package com.evently.app.security;

import com.evently.app.role.TypeDeRole;
import com.evently.app.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.evently.app.role.TypeDeRole.ADMINISTRATEUR;
import static com.evently.app.role.TypeDeRole.UTILISATEUR;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfigurationSecurityApplication {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final  JwtFilter jwtFilter;
    private  final UserDetailsService userDetailsService;

    public ConfigurationSecurityApplication(BCryptPasswordEncoder bCryptPasswordEncoder, JwtFilter jwtFilter, UserDetailsService userDetailsService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtFilter = jwtFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return
                httpSecurity
                        .csrf(AbstractHttpConfigurer ::disable)

                        .authorizeHttpRequests(
                                authorize ->
                                        authorize.requestMatchers(POST, "/inscription","/api/v1/rest/clients/inscription","/api/v1/rest/prestataires/inscription","/api/v1/rest/admins/inscription").permitAll()
                                                 .requestMatchers(POST,"/activation").permitAll()
                                                 .requestMatchers(POST,"/connexion").permitAll()
                                                 .requestMatchers(POST,"/modifier-mot-de-passe").permitAll()
                                                 .requestMatchers(POST,"/nouveau-mot-de-passe").permitAll()
                                                 .requestMatchers(POST,"/refresh-token").permitAll()
/*
                                                .requestMatchers(POST,"/api/v1/rest/admins/**").hasRole(String.valueOf(ADMINISTRATEUR))
                                                .requestMatchers(GET,"/api/v1/rest/admins/**").hasRole(String.valueOf(ADMINISTRATEUR))
                                                .requestMatchers(PUT,"/api/v1/rest/admins/**").hasRole(String.valueOf(ADMINISTRATEUR))
                                                .requestMatchers(DELETE,"/api/v1/rest/admins/**").hasRole(String.valueOf(ADMINISTRATEUR))
                                                .requestMatchers(POST,"/api/v1/rest/clients/**").hasAnyRole(String.valueOf(ADMINISTRATEUR), String.valueOf(UTILISATEUR))
                                                .requestMatchers(GET,"/api/v1/rest/clients/**").hasAnyRole(String.valueOf(ADMINISTRATEUR), String.valueOf(UTILISATEUR))
                                                .requestMatchers(PUT,"/api/v1/rest/clients/**").hasAnyRole(String.valueOf(ADMINISTRATEUR), String.valueOf(UTILISATEUR))
                                                .requestMatchers(DELETE,"/api/v1/rest/clients/**").hasAnyRole(String.valueOf(ADMINISTRATEUR), String.valueOf(UTILISATEUR))
                                                .requestMatchers(POST,"/api/v1/rest/prestataires/**").hasAnyRole(String.valueOf(ADMINISTRATEUR), String.valueOf(UTILISATEUR))
                                                .requestMatchers(GET,"/api/v1/rest/prestataires/**").hasAnyRole(String.valueOf(ADMINISTRATEUR), String.valueOf(UTILISATEUR))
                                                .requestMatchers(PUT,"/api/v1/rest/prestataires/**").hasAnyRole(String.valueOf(ADMINISTRATEUR), String.valueOf(UTILISATEUR))
                                                .requestMatchers(DELETE,"/api/v1/rest/prestataires/**").hasAnyRole(String.valueOf(ADMINISTRATEUR), String.valueOf(UTILISATEUR))
*/
                                                .requestMatchers("/inscription","/api/v1/auth/**", "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**", "/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security", "/swagger-ui/**", "/webjars/**", "/swagger-ui.html").permitAll()
                                                 .anyRequest().authenticated()
                        ).sessionManagement(httpSecuritySessionManagementConfigurer ->
                                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();

    }
    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public AuthenticationProvider authenticationProvider (UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return daoAuthenticationProvider;
    }
}
