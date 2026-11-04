
package com.example.demo.config.com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .authorizeHttpRequests(auth -> auth

                // 1. 공개 페이지
                .requestMatchers(
                    "/", "/hello",
                    "/detailed_web*.html", "/detailed_web*",
                    "/login", "/signup", "/error"
                ).permitAll()

                // 2. 정적 리소스
                .requestMatchers(
                    "/css/**", "/js/**",
                    "/images/**", "/fonts/**"
                ).permitAll()

                // 3. 관리자 전용 페이지 및 API
                .requestMatchers("/admin/**", "/api/admin/**")
                    .hasRole("ADMIN")

                // 4. ADMIN과 MANAGER만 /testdb 접근 가능
                .requestMatchers("/testdb")
                
                    .hasAnyRole("ADMIN", "MANAGER")

                // 5. 공개 API
                .requestMatchers("/api/hello").permitAll()

                .requestMatchers("/board", "/board/{id:\\d+}").permitAll() // 게시판 목록·상세 : 누구나

                // 6. 나머지 요청은 로그인한 사용자만 접근
                .anyRequest().authenticated()
            )

            // 로그인 설정
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll()
            )

            // 로그아웃 설정
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
            )

            // 로그인 유지 설정
            .rememberMe(rm -> rm
                .key("remember-me-key")
                .tokenValiditySeconds(60 * 60 * 24 * 7)
            )

            // Postman 등의 HTTP Basic 인증
            .httpBasic(Customizer.withDefaults())

            // API 요청은 CSRF 검사 제외
            .csrf(csrf ->
                csrf.ignoringRequestMatchers("/api/**")
            )

            // 인증되지 않은 API 요청은 401 응답
            .exceptionHandling(ex ->
                ex.defaultAuthenticationEntryPointFor(
                    new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
                    request ->
                        request.getRequestURI().startsWith("/api/")
                )
            );

        return http.build();
    }
}
