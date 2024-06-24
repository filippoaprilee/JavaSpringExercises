package org.noleggioauto.Service.Impl;

import org.noleggioauto.*;
import org.noleggioauto.Service.NoleggioService;
import java.util.*;

public class NoleggioServiceImpl implements NoleggioService {
    private Noleggio noleggio = new Noleggio();

    public NoleggioServiceImpl(ClienteServiceImpl clienteService, AutoServiceImpl autoService) {
    }

    @Override
    public void aggiungiNoleggio(Cliente cliente, Auto auto) {
        noleggio.aggiungiNoleggio(cliente, auto);
        System.out.println("Il cliente " + cliente.getNome() + " ha noleggiato l'auto " + auto.getModello() + " con targa " + auto.getTarga() + " con successo.");
    }

    @Override
    public Noleggio trovaNoleggio(Cliente cliente) {
        Auto autoNoleggiata = noleggio.trovaNoleggio(cliente);
        if (autoNoleggiata != null) {
            return noleggio;
        }
        System.out.println("Nessun noleggio trovato per il cliente " + cliente.getNome() + " " + cliente.getCognome());
        return null;
    }

    @Override
    public void eliminaNoleggio(Cliente cliente) {
        noleggio.eliminaNoleggio(cliente);
        System.out.println("Il noleggio per il cliente " + cliente.getNome() + " " + cliente.getCognome() + " è stato eliminato con successo.");
    }

    @Override
    public List<Noleggio> listaNoleggi() {
        List<Noleggio> lista = new ArrayList<>();
        lista.add(noleggio);
        return lista;
    }
}
