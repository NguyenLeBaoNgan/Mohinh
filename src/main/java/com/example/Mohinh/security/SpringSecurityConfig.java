package com.example.Mohinh.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@AllArgsConstructor
public class SpringSecurityConfig {

    private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/webjars/**", "/assets/**").permitAll()
                                .requestMatchers("/product").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                    .requestMatchers("/product/view").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                                    .requestMatchers("/product/add").hasAuthority("ROLE_ADMIN")
                                    .requestMatchers("/product/edit").hasAuthority("ROLE_ADMIN")
                                    .requestMatchers("/product/update").hasAuthority("ROLE_ADMIN")
                                    .requestMatchers("/product/delete/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/product/addTL").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/product/editTL").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/product/updateTL").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/product/deleteTL/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/product/addNSX").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/product/editNSX").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/product/updateNSX").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/product/deleteNSX/**").hasAuthority("ROLE_ADMIN")
                                    .requestMatchers("/shoppingcart").hasAuthority("ROLE_USER")
                                    .requestMatchers("/shoppingcart/view").hasAuthority("ROLE_USER")
                                    .requestMatchers("/shoppingcart/add/**").hasAuthority("ROLE_USER")
                                    .requestMatchers("/shoppingcart/clear").hasAuthority("ROLE_USER")
                                    .requestMatchers("/shoppingcart/delete/**").hasAuthority("ROLE_USER")
                                    .requestMatchers("/shoppingcart/update").hasAuthority("ROLE_USER")
                                    .requestMatchers("/register").permitAll()
                                    .anyRequest().authenticated()
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/product/view")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}