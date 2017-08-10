package es.bjt.photowall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PhotowallApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotowallApplication.class, args);
	}
}
