package com.telusko.spring_security.config;

import com.telusko.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
/* @EnableWebSecurity
    Used in Spring Security to enable web security configuration in a Spring Boot o Spring-based application. It serves as a marker to inform Spring that we are defining a custom web security configuration.
*/
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
//    private UserDetailsService userDetailsService;
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request ->
                        request.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults()) // No longer needed since the sessionCreationPolicy is stateless.
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Csrf Configuration without Lamda Expression
        /*
        Customizer<CsrfConfigurer<HttpSecurity>> csrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> configurer) {
                configurer.disable();
            }
        };*/

        // AuthorizeHttpRequest without lambda Expression
        /*Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> authorizeHttpRequests = new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
            @Override
            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
                registry.anyRequest().authenticated();
            }
        };*/

        // SessionManagement without Lambda Expression
        /*Customizer<SessionManagementConfigurer<HttpSecurity>> sessionManagement = new Customizer<SessionManagementConfigurer<HttpSecurity>>() {
            @Override
            public void customize(SessionManagementConfigurer<HttpSecurity> custom) {
                custom.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            }
        };*/

        return http.build(); // Return the object of SecurityFilterChain
    }

    // Allow Us to Manage Custom usernames and passwords from InMemory
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User
                .withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails admin = User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMINISTRATOR")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // We set BCrypt encoder in the next line
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }
}
