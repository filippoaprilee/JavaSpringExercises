package org.autowirespring;

public class MessaggiService {
    private String messaggioPredefinito;

    public MessaggiService() {
        super();
    }

    public void setMessaggioPredefinito(String messaggioPredefinito) {
        this.messaggioPredefinito = messaggioPredefinito;
    }

    public void inviaMessaggio(String destinatario, String messaggio) {
        System.out.println("Messaggio inviato a " + destinatario + ": " + messaggio);
    }

    public void visualizzaMessaggi() {
        System.out.println("Visualizzazione messaggi");
    }
}
