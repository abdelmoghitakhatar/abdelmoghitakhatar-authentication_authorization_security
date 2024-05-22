package com.spring.app.security;

import com.spring.app.security.filters.JwtAuthenticationEntryPoint;
import com.spring.app.security.filters.JwtAuthenticationFilter1;
import com.spring.app.security.filters.JwtProvider;
import com.spring.app.security.userAuthInfo.UserInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  private JwtAuthenticationEntryPoint authenticationEntryPoint;
  private JwtProvider jwtProvider;
  private UserDetailsService userDetailsService;

  public SecurityConfiguration(JwtAuthenticationEntryPoint authenticationEntryPoint, JwtProvider jwtProvider, UserDetailsService userDetailsService) {
    this.authenticationEntryPoint = authenticationEntryPoint;
    this.jwtProvider = jwtProvider;
    this.userDetailsService = userDetailsService;
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

//  @Bean
//  public UserDetailsService userDetailsService(){
//    return new UserInfoService();
//  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    http
      .csrf(AbstractHttpConfigurer::disable)
      .exceptionHandling(
        exception -> exception.authenticationEntryPoint(authenticationEntryPoint)
      )
      .sessionManagement(
        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      )
      .authorizeHttpRequests(
        (auth) -> auth
          .requestMatchers(HttpMethod.POST, "/login").permitAll()
          .requestMatchers(HttpMethod.POST, "/register").permitAll()
          .anyRequest().authenticated()
      )
      .httpBasic(Customizer.withDefaults());
    http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

//  @Bean
//  public AuthenticationProvider authenticationProvider(){
//    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//
//    auth.setUserDetailsService(userDetailsService());
//    auth.setPasswordEncoder(passwordEncoder());
//    return auth;
//  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public JwtAuthenticationFilter1 jwtAuthenticationFilter(){
    return new JwtAuthenticationFilter1(userDetailsService, jwtProvider);
  }
}
