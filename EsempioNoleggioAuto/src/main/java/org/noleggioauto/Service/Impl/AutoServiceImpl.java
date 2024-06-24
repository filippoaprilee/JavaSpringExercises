package org.noleggioauto.Service.Impl;

import org.noleggioauto.Service.AutoService;
import org.noleggioauto.*;

import java.util.*;
import java.util.stream.Collectors;

public class AutoServiceImpl implements AutoService {
    private Map<String, Auto> autoMap = new HashMap<>();

    @Override
    public void aggiungiAuto(Auto auto) {
        autoMap.put(auto.getTarga(), auto);
        System.out.println("L'auto " + auto.getModello() + " con targa " + auto.getTarga() + " è stata aggiunta con successo.");
    }

    @Override
    public Auto trovaAuto(String targa) {
        return autoMap.get(targa);
    }

    @Override
    public List<Auto> trovaAutoByModello(String modello) {
        return autoMap.values().stream()
                .filter(auto -> auto.getModello().equalsIgnoreCase(modello))
                .collect(Collectors.toList());
    }

    @Override
    public void eliminaAuto(String targa) {
        autoMap.remove(targa);
    }

    @Override
    public List<Auto> listaAuto(StatoPrenotazione stato) {
        return autoMap.values().stream()
                .filter(auto -> auto.getStatoPrenotazione() == stato)
                .collect(Collectors.toList());
    }
}
