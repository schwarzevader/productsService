package com.example.productsservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;


//@EnableWebFluxSecurity
@Configuration
@EnableWebSecurity

public class SecurityConfig {

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeHttpRequests()
//
//                // require the user to have the "user" role
//                .antMatchers("/**").hasRole("user")
//                .anyRequest().authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt()
//                .jwtAuthenticationConverter(jwtAuthenticationConverter());
//        return http.build();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and()
                .csrf().disable()
                .cors();
     //   http.requiresChannel().anyRequest().requiresSecure();
        return http.build();
    }

//    JwtAuthenticationConverter jwtAuthenticationConverter() {
//        final JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
//        return jwtAuthenticationConverter;
//    }
//
//
//    @Bean
//    ReactiveJwtDecoder jwtDecoder() {
//        //return ReactiveJwtDecoders.fromOidcIssuerLocation("http://localhost:8080/realms/spring-microservices");
//        return ReactiveJwtDecoders.fromOidcIssuerLocation("http://localhost:8080/auth/realms/spring-microservice");
//    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
        return source;

    }

}