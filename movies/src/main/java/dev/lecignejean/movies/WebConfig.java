package dev.lecignejean.movies;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This is a configuration class for the web application.
 * It implements the WebMvcConfigurer interface to customize the Java-based configuration for Spring MVC.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * This method is used to add CORS mappings.
     * It allows requests from the specified origins to all endpoints ("/**").
     * It also allows all HTTP methods and headers, and supports credentials.
     * @param registry This is the CorsRegistry to which the mappings are added.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}