package com.tamaspinter.usermanagement.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http.authorizeHttpRequests()
                .requestMatchers("/users/update/{id}", "/users/delete/{id}").authenticated() // Allow public access to the users endpoint
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .build()
    }
}
