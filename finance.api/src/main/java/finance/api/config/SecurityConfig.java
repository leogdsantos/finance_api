package finance.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          .csrf(csrf -> csrf.disable()) // desabilita CSRF para facilitar testes com API REST
          .authorizeHttpRequests(auth -> auth
              .anyRequest().authenticated() // exige autenticação para qualquer requisição
          )
          .httpBasic(); // ativa autenticação básica (Basic Auth)

        return http.build();
    }
}

