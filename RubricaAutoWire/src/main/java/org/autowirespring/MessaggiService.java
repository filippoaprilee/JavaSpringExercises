package org.autowirespring;

public class MessaggiService {
    private String messaggioPredefinito;

    public void inviaMessaggio(String destinatario, String testo) {
        System.out.println("Messaggio inviato a " + destinatario + ": " + testo);
    }

    public void visualizzaMessaggi() {
        System.out.println("Visualizzazione messaggi");
    }

    public void setMessaggioPredefinito(String messaggioPredefinito) {
        this.messaggioPredefinito = messaggioPredefinito;
    }

    public void mostraInfo() {
        System.out.println("MessaggiService: " + messaggioPredefinito);
    }
}
