package org.noleggioauto;

import java.util.HashMap;
import java.util.Map;

public class Noleggio {
    private Map<Auto, Cliente> noleggi = new HashMap<>();

    // Metodi getter e setter per 'noleggi'
    public Map<Auto, Cliente> getNoleggi() {
        return noleggi;
    }

    public void setNoleggi(Map<Auto, Cliente> noleggi) {
        this.noleggi = noleggi;
    }

    // Metodo per aggiungere un noleggio
    public void aggiungiNoleggio(Cliente cliente, Auto auto) {
        noleggi.put(auto, cliente);
        auto.setStatoPrenotazione(StatoPrenotazione.NON_DISPONIBILE);
    }

    // Metodo per eliminare un noleggio
    public void eliminaNoleggio(Cliente cliente) {
        Auto autoDaRimuovere = null;
        for (Map.Entry<Auto, Cliente> entry : noleggi.entrySet()) {
            if (entry.getValue().equals(cliente)) {
                autoDaRimuovere = entry.getKey();
                break;
            }
        }
        if (autoDaRimuovere != null) {
            noleggi.remove(autoDaRimuovere);
            autoDaRimuovere.setStatoPrenotazione(StatoPrenotazione.DISPONIBILE);
        }
    }

    // Metodo per trovare un noleggio specifico per un cliente
    public Auto trovaNoleggio(Cliente cliente) {
        for (Map.Entry<Auto, Cliente> entry : noleggi.entrySet()) {
            if (entry.getValue().equals(cliente)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Il noleggio della macchina di marca " + trovaNoleggio(noleggi.values().iterator().next()).getMarca() + " e modello " + trovaNoleggio(noleggi.values().iterator().next()).getModello() +
                " è stato effettuato da " + noleggi.values().iterator().next().getNome() + " " + noleggi.values().iterator().next().getCognome();
    }
}