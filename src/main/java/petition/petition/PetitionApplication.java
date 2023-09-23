package petition.petition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import petition.petition.global.security.jwt.JwtProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties(JwtProperties.class)
public class PetitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetitionApplication.class, args);
	}

}
