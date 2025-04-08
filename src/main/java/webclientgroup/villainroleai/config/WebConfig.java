package webclientgroup.villainroleai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class WebConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("*")); //allow all endpoints to access.
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); //allow HTTP methods.
        config.setAllowedHeaders(List.of("*")); //allow all HTTP headers.

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source); //return cors filter based on CorsConfiguration config.
    }
}
