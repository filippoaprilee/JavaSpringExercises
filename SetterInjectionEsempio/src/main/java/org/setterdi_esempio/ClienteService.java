package org.setterdi_esempio;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    public List<String> clienti() {
        List<String> listaClienti = new ArrayList<>();
        listaClienti.add("Cliente 1");
        listaClienti.add("Cliente 2");
        listaClienti.add("Cliente 3");

        return listaClienti;
    }
}
