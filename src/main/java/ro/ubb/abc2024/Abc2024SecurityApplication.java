package ro.ubb.abc2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ro.ubb.abc2024.security.config.RsaKeyProperties;

@Configuration
@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
@EnableConfigurationProperties(RsaKeyProperties.class)
public class Abc2024SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Abc2024SecurityApplication.class, args);
	}

}
