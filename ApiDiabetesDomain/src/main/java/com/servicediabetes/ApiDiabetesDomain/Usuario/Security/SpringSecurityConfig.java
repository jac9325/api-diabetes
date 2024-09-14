package com.servicediabetes.ApiDiabetesDomain.Usuario.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.servicediabetes.ApiDiabetesDomain.Usuario.Security.Filter.JwtAuthenticationFilter;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Security.Filter.JwtValidationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((authz) -> authz
                //.requestMatchers("/api/v1/usuario/createUser").permitAll()
                //.requestMatchers(HttpMethod.POST, "/api/v1/usuario/registrarNuevosUsuarios/{id_sucursal}/{fecha_inicio}/{fecha_fin}").permitAll()
                //.requestMatchers(HttpMethod.GET, "/api/v1/usuario/getUserAndRols/{username}").permitAll()  
                .requestMatchers(HttpMethod.POST, "/api/usuario/").permitAll()   
                //.requestMatchers(HttpMethod.GET, "/api/usuario/getUserByEmail/{email}").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/usuario/goImage/{filename}").permitAll()
                //.requestMatchers(HttpMethod.GET, "/api/usuario/getUrlImage/{filename}").permitAll()
                //.requestMatchers(HttpMethod.GET, "/api/usuario/UrlImage/{filename}").permitAll()

                //.requestMatchers(HttpMethod.GET, "/api/usuario/deleteImagen/{filename}").permitAll()    
                .anyRequest()
                .authenticated())
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtValidationFilter(authenticationManager()))
                .csrf(config -> config.disable())
                .cors(cors->cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<>(
            new CorsFilter(corsConfigurationSource()));
        corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsBean;
    }
}