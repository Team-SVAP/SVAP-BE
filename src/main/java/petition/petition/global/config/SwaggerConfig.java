package petition.petition.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info =
        @Info(
                title = "SVAP : 테스트용 API 명세서",
                description = "강태양"))
@Configuration
public class SwaggerConfig {}
