package it.apuliadigital.Artist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ArtistApplication {

	private static final Logger log = LoggerFactory.getLogger(ArtistApplication.class);

	public static void main(String[] args) {
		// Chiede all'utente se ha letto il file README.md
		if (!askIfReadReadme()) {
			// Se l'utente risponde "N", mostra il messaggio e termina l'esecuzione
			System.out.println("Guarda il file README!");
			System.exit(0);  // Ferma l'avvio dell'applicazione
		}

		// Se l'utente risponde "Y", procede con l'avvio
		BootCounter.incrementBootCount();

		// Mostra il numero di avvii
		int bootCount = BootCounter.getBootCount();
		log.info(ColorUtil.colorize("Server started successfully for the " + bootCount + " time!", ColorUtil.GREEN));

		// Avvio dell'applicazione
		SpringApplication.run(ArtistApplication.class, args);
	}

	private static boolean askIfReadReadme() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hai già letto il README file? Y/N");

		String answer = scanner.nextLine().trim().toUpperCase();
		return "Y".equals(answer);  // Ritorna true se la risposta è "Y", altrimenti false
	}
}
