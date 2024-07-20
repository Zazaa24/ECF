package com.zaza.ecf.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

        @Bean
        public PasswordEncoder passwordEncoder() {
            return NoOpPasswordEncoder.getInstance();
        }
        @Bean
        public AuthenticationManager authenticationManager(final AuthenticationConfiguration authenticationConfiguration) throws Exception {
            return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(Customizer.withDefaults())
                    .cors(Customizer.withDefaults())
                    .sessionManagement(httpSecuritySessionManagementConfigurer ->httpSecuritySessionManagementConfigurer
                            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                    .authorizeHttpRequests((authorize) -> authorize
                            .requestMatchers("/gestion-avis","/gestion-alimentation").hasRole("EMPLOYE")
                            .requestMatchers("/ajout-rapport","/visualisation-alimentations").hasRole("VETERINAIRE")
                            .requestMatchers("/gestion-utilisateurs","/gestion-horaires","/gestion-races","/gestion-animaux","/visualisation-rapports").hasRole("ADMINISTRATEUR")
                            .requestMatchers("/gestion-habitats").hasAnyRole("ADMINISTRATEUR", "VETERINAIRE")
                            //.requestMatchers("/gestion-services").hasAnyRole("ADMINISTRATEUR", "EMPLOYE")
                            .anyRequest().permitAll())
                    .formLogin((form) -> form
                            .loginPage("/login")
                            .loginProcessingUrl("/login")
                            .defaultSuccessUrl("/accueil")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .permitAll())
                    .logout((logout) -> logout
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/accueil")
                            .permitAll())
                    .exceptionHandling(ex -> ex.accessDeniedPage("/non-autorise"));


            return http.build();


    }
}
