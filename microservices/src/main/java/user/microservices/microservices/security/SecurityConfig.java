package user.microservices.microservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    final AuthenticationManager authMgr;

    SecurityConfig(AuthenticationManager authMgr) {
        this.authMgr = authMgr;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(requests -> requests.requestMatchers("/login").permitAll()

                        .anyRequest().authenticated())
                // Pas oublier d'enlever le point virgule

                .addFilterBefore(new JWTAuthenticationFilter(authMgr),
                        UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
*/

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
            AuthenticationManager authMgr) throws Exception {

        // JWTAuthenticationFilter authenticationFilter = new
        // JWTAuthenticationFilter(authMgr);

        http
                .csrf(csrf -> csrf.disable())

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/all").hasAuthority("ADMIN")
                        .anyRequest().authenticated())

                .addFilter(new JWTAuthenticationFilter(authMgr))

                .addFilterBefore(new JWTAuthorizationFilter(),
                        JWTAuthenticationFilter.class);

        return http.build();
    }
}
