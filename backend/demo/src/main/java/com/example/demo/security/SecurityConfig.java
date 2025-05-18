package com.example.demo.security;

import com.example.demo.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//definisem objekte ovih novih klasa, konstruktorska injekcija, ovde se odredjuje sta se desava sa zahtjevima, odnosno koje rute
//zahtijevaju autentifikaciju a koje ne

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthEntryPointJwt unauthorizedHandler;
    private final AuthTokenFilter authTokenFilter;
    private final CustomUserDetailsService userDetailsService; // Potreban za AuthenticationProvider

    public SecurityConfig(AuthEntryPointJwt unauthorizedHandler,
                          AuthTokenFilter authTokenFilter,
                          CustomUserDetailsService userDetailsService) {
        this.unauthorizedHandler = unauthorizedHandler;
        this.authTokenFilter = authTokenFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean //kad se injektuje password encoder spring ce se pobrinuti da se koristi ovako definisana instanca
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. Onemogući CSRF (Cross-Site Request Forgery) - uobičajeno za stateless REST API
                .csrf(AbstractHttpConfigurer::disable)

                // 2. Konfiguriši rukovanje izuzecima, posebno za greške autentifikacije
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(unauthorizedHandler) // Koristi tvoj AuthEntryPointJwt za 401 greške
                )

                // 3. Konfiguriši upravljanje sesijama da bude STATELESS (bez sesija)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // 4. Definiši pravila autorizacije (ko može pristupiti čemu)
                .authorizeHttpRequests(authz -> authz
                        // Dozvoli SVIMA pristup /api/users/login endpointu (za POST metodu)
                        .requestMatchers(HttpMethod.POST, "/api/users/login").permitAll()

                        // !!! Ako imaš endpoint za registraciju (npr. POST /api/users), OBAVEZNO ga dodaj ovde:
                        // .requestMatchers(HttpMethod.POST, "/api/users").permitAll()

                        // Zahtevaj AUTENTIFIKACIJU za SVE OSTALE zahteve
                        .anyRequest().authenticated()
                )

                // 5. Eksplicitno dodaj AuthenticationProvider (dobra praksa)
                .authenticationProvider(authenticationProvider())

                // 6. Dodaj tvoj AuthTokenFilter PRE standardnog UsernamePasswordAuthenticationFilter-a
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // Izgradi i vrati SecurityFilterChain
        return http.build();
    }
}