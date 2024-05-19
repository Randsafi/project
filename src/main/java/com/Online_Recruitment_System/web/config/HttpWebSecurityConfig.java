package com.Online_Recruitment_System.web.config;

import com.Online_Recruitment_System.web.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class HttpWebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(HttpMethod.POST,"/user/login", "/user/register").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/companies/register", "/jobseekers/register").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/user/login", "/user/register").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/user/login")
//                        .usernameParameter("email")
//                        .defaultSuccessUrl("/vacants/all")
//                        .loginProcessingUrl("/user/login")
//                        .failureUrl("/user/login?error=true")
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());

//        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    private CustomUserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;


    public HttpWebSecurityConfig(CustomUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder);
    }
}
