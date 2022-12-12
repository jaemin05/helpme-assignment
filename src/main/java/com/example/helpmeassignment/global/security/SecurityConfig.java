package com.example.helpmeassignment.global.security;

import com.example.helpmeassignment.global.security.jwt.JwtTokenFilter;
import com.example.helpmeassignment.global.security.jwt.JwtTokenParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final JwtTokenParser jwtTokenParser;
    private final ObjectMapper objectMapper;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin().disable()
                .csrf().disable()
                .cors();

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/admin").permitAll()
                .requestMatchers(HttpMethod.POST, "/admin/login").permitAll()

                .requestMatchers(HttpMethod.POST, "/member").authenticated()
                .requestMatchers(HttpMethod.POST, "/member/{member-id}").authenticated()

                .requestMatchers(HttpMethod.POST, "/deposit").authenticated()
                .requestMatchers(HttpMethod.GET, "/deposit").authenticated()
                .requestMatchers(HttpMethod.GET, "/deposit/{member-id}").authenticated()
                .requestMatchers(HttpMethod.GET, "/deposit/total").authenticated()
                .requestMatchers(HttpMethod.GET, "/deposit/time").authenticated()

                .requestMatchers(HttpMethod.POST, "/use").authenticated()
                .requestMatchers(HttpMethod.GET, "/use").authenticated()
                .requestMatchers(HttpMethod.GET, "/use/time").authenticated()

                .requestMatchers(HttpMethod.GET, "/excel/deposit").permitAll()
                .requestMatchers(HttpMethod.GET, "/excel/deposit/{member-id}").permitAll()
                .requestMatchers(HttpMethod.GET, "/excel/deposit/time").permitAll()

                .requestMatchers(HttpMethod.GET, "/excel/use").permitAll()
                .requestMatchers(HttpMethod.GET, "/excel/use/time").permitAll()

                .anyRequest().authenticated();

        http
                .apply(new FilterConfig(jwtTokenParser, objectMapper));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
