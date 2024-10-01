//package com.systex.hw4.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authz -> authz
//                        // Publicly accessible pages
//                        .requestMatchers("/", "/index.jsp", "/auth/login", "/auth/register", "/h2-console/**", "/style/**").permitAll()
//                        // Pages under /game/** and /lottery/** should be restricted to authenticated users only
//                        .anyRequest().authenticated()  // All other pages require authentication
//                )
//                .formLogin(form -> form
//                        .loginPage("/auth/login")  // Specify custom login page located in /WEB-INF/pages/auth/login.jsp
//                        .permitAll()  // (4)
//                        .defaultSuccessUrl("/index.jsp", true)  // (5)
//                        .failureUrl("/auth/login?error=true")
//                )
////                .logout(logout -> logout
////                        .logoutUrl("/auth/logout")  // (7)
////                        .logoutSuccessUrl("/auth/login?logout=true")  // (8)
////                        .permitAll()
////                )
//                .csrf(csrf -> csrf.disable())  // Disable CSRF for H2 console access (not recommended for production)
//                .headers(headers -> headers
//                        .frameOptions(frameOptions -> frameOptions.sameOrigin())  // Allow same-origin for iframe embedding
//                );
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();  // Using BCrypt for password hashing
//    }
//}