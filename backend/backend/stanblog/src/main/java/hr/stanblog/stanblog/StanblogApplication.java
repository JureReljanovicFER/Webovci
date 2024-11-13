package hr.stanblog.stanblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class StanblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(StanblogApplication.class, args);
	}

}
