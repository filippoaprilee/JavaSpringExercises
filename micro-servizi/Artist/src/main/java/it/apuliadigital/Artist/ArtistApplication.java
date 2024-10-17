package it.apuliadigital.Artist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtistApplication {

	public static void main(String[] args) {
		BootCounter.incrementBootCount();

		// Mostra il numero di avvii
		Logger log = LoggerFactory.getLogger(ArtistApplication.class);
		int bootCount = BootCounter.getBootCount();
		// log.info("\uD83D\uDE80 Application has been started {} times!", bootCount);
		log.info(ColorUtil.colorize("Server started successfully for the " + bootCount + " time!", ColorUtil.GREEN));

		// Avvio dell'applicazione
		SpringApplication.run(ArtistApplication.class, args);
	}

}
