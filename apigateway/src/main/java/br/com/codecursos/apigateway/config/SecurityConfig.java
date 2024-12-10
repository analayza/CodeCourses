package br.com.codecursos.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtConverter jwtConverter;

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                aut -> aut.requestMatchers
                        ("/course-app").hasRole("TEACHER")
                        .requestMatchers("/student").hasRole("STUDENT")
                        .requestMatchers("/registerCourse").hasRole("STUDENT")
                        .anyRequest().authenticated())
                .oauth2ResourceServer(o -> o.jwt(
                        jwt -> jwt.jwtAuthenticationConverter(jwtConverter)
                ));
        return http.build();
    }
}
