package it.apuliadigital.anagraficaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import it.apuliadigital.anagraficaClient.client.api.PersonaApi;

@SpringBootApplication
public class AnagraficaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnagraficaClientApplication.class, args);
	}

	@Bean
	public PersonaApi albumApiClient() {
		PersonaApi albumApiClient = new PersonaApi();
		albumApiClient.getApiClient().setBasePath("http://127.0.0.1:8081");
		return albumApiClient;
	}

}
