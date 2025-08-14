package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // CSRF 보호 활성화 
            .csrf(csrf -> csrf.disable())
            
            // HTTP 요청에 대한 인가 규칙 설정
            .authorizeHttpRequests(authorize -> authorize
                // 인증 없이 접근 가능한 경로
                .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/usr/login", "/login", "/signup").permitAll()
                // 특정 역할(ROLE_USER)이 필요한 경로
                .requestMatchers("/myPage").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                // 그 외 모든 요청은 인증 필요
                .anyRequest().authenticated()
            )
            
            // 폼 기반 로그인 설정
            .formLogin(form -> form
                .loginPage("/usr/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)        // 로그인 성공 시 리디렉션될 기본 페이지
                .failureUrl("/usr/login?error=true")     // 로그인 실패 시 리디렉션될 페이지
                .permitAll()                         // 로그인 페이지 접근은 모두 허용
                // .oauth2Login(oauth2 -> oauth2
                //     .loginPage("/usr/login")
                //     .defaultSuccessUrl("/", true)
                //     .permitAll()
                // )
            )
            
            // 로그아웃 설정
            .logout(logout -> logout
                .logoutUrl("/logout")                // 로그아웃 처리 URL
                .logoutSuccessUrl("/login?logout")   // 로그아웃 성공 시 리디렉션될 페이지
                .invalidateHttpSession(true)         // HTTP 세션 무효화
                .deleteCookies("JSESSIONID")         // 쿠키 삭제
                .permitAll()
            );

        // H2-console을 위한 프레임 옵션 비활성화
        // http.headers(headers -> headers.frameOptions().disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
