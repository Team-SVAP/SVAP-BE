package petition.petition.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins(
                        "https://prod-server.xquare.app/*",
                        "http://localhost:3000",
                        "http://lcoalhost:3001",
                        "http://localhost:4000"
                )
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "HEAD")
                .allowedHeaders("*");
    }

}
*/