package it.apuliadigital.DockerJAR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DockerJarApplication {

	Logger logger = LoggerFactory.getLogger(DockerJarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DockerJarApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		logger.info("Hello Docker World");
		return "Hello Docker World";
	}
}
