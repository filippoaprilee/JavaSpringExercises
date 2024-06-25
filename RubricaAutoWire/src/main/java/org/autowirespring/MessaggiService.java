package org.autowirespring;

import java.util.*;

public class MessaggiService {
    private String messaggioPredefinito;
    private Map<Long, String> messaggi = new HashMap<>();

    public MessaggiService() {
        super();
        messaggi.put(1L, "Ciao");
        messaggi.put(2L, "Hello");
        messaggi.put(3L, "Hola");
        messaggi.put(4L, "Bonjour");
    }

    public void setMessaggioPredefinito(String messaggioPredefinito) {
        this.messaggioPredefinito = messaggioPredefinito;
    }

    public String getMessaggi(long idUser) {
        return messaggi.getOrDefault(idUser, messaggioPredefinito);
    }

    public void mostraInfo() {
        System.out.println("Messaggio predefinito: " + messaggioPredefinito);
    }
}
