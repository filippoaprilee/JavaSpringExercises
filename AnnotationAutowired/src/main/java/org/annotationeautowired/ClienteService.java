package org.annotationeautowired;

import org.springframework.stereotype.Component;

import java.util.*;

@Component(value="cliente")
public class ClienteService {

    private Map<Integer, String> clienti = new HashMap<Integer, String>();

    public ClienteService() {
        clienti.put(123, "Mario Rossi");
        clienti.put(124, "Luca Bianchi");
        clienti.put(125, "Giuseppe Verdi");
    }

    public String getCliente(int id) {
       return clienti.getOrDefault(id, "Cliente non trovato");
    }

    public String sayHello() {
        return "ciao sono un cliente";
    }

    public Map<Integer, String> tuttiClienti() {
        return clienti;
    }
}
