package org.noleggioauto;

import org.noleggioauto.Service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Caricamento del contesto Spring dal file services.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

        // Ottenere i servizi necessari dal contesto Spring
        NoleggioService noleggioService = context.getBean("noleggioService", NoleggioService.class);
        ClienteService clienteService = context.getBean("clienteService", ClienteService.class);
        AutoService autoService = context.getBean("autoService", AutoService.class);

        // Esempio di utilizzo dei servizi per gestire le operazioni

        // Aggiunta di clienti e auto
        System.out.println("Aggiunta di clienti:");
        clienteService.aggiungiCliente(new Cliente(1, "Mario", "Rossi", "3331234567", "mario.rossi@example.com"));
        clienteService.aggiungiCliente(new Cliente(2, "Anna", "Verdi", "3337654321", "anna.verdi@example.com"));
        clienteService.aggiungiCliente(new Cliente(3, "Luca", "Bianchi", "3339876543", "lucabianchi@example.com"));
        System.out.println();

        System.out.println("Aggiunta di auto:");
        autoService.aggiungiAuto(new Auto("AB123CD", "Fiat", "Panda", 5, TipoAuto.UTILITARIA, StatoPrenotazione.DISPONIBILE));
        autoService.aggiungiAuto(new Auto("XY987ZW", "Volkswagen", "Golf", 5, TipoAuto.STATION_WAGON, StatoPrenotazione.DISPONIBILE));
        autoService.aggiungiAuto(new Auto("AB456CD", "Fiat", "500", 4, TipoAuto.UTILITARIA, StatoPrenotazione.DISPONIBILE));
        autoService.aggiungiAuto(new Auto("XY123ZW", "Volkswagen", "Polo", 5, TipoAuto.UTILITARIA, StatoPrenotazione.DISPONIBILE));
        System.out.println();

        // Aggiunta di noleggi
        System.out.println("Aggiunta di noleggi: ");
        noleggioService.aggiungiNoleggio(clienteService.trovaCliente(1), autoService.trovaAuto("AB123CD"));
        noleggioService.aggiungiNoleggio(clienteService.trovaCliente(2), autoService.trovaAuto("XY987ZW"));

        // Lista dei noleggi
        noleggioService.listaNoleggi().forEach(System.out::println);


        // Trova noleggio per cliente
        System.out.println("\nNoleggio di Mario Rossi:");
        System.out.println(noleggioService.trovaNoleggio(clienteService.trovaCliente(1)));


        // Lista dei clienti e delle auto
        List<Cliente> clienti = clienteService.listaClienti();
        List<Auto> autoDisponibili = autoService.listaAuto(StatoPrenotazione.DISPONIBILE);

        System.out.println();
        // Output della lista dei clienti e delle auto disponibili
        System.out.println("Lista dei Clienti:");
        clienti.forEach(System.out::println);

        System.out.println("\nLista delle Auto Disponibili:");
        autoDisponibili.forEach(System.out::println);

        // Eliminazione di un cliente e dell'auto associata
        clienteService.eliminaCliente(2);

        // Lista aggiornata dei clienti dopo l'eliminazione
        System.out.println("\nLista dei Clienti dopo l'eliminazione di Anna Verdi:");
        clienteService.listaClienti().forEach(System.out::println);

        // Trova auto per modello
        autoService.trovaAutoByModello("Panda").forEach(System.out::println);

        // Eliminazione di un'auto
        autoService.eliminaAuto("XY123ZW");

        // Lista aggiornata delle auto disponibili dopo l'eliminazione
        System.out.println("\nLista delle Auto Disponibili:");
        autoDisponibili.forEach(System.out::println);
    }
}
