package org.autowirespring;

public class RubricaService {
    private MessaggiService messaggiService;
    private String nome;

    public void setMessaggiService(MessaggiService messaggiService) {
        this.messaggiService = messaggiService;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void inviaMessaggio(String destinatario, String testo) {
        messaggiService.inviaMessaggio(destinatario, testo);
    }

    public void visualizzaMessaggi() {
        messaggiService.visualizzaMessaggi();
    }

    public void setmessaggioPredefinito(String messaggioPredefinito) {
        messaggiService.setMessaggioPredefinito(messaggioPredefinito);
    }

    public void mostraInfo() {
        System.out.println("RubricaService: " + nome);
        messaggiService.mostraInfo();
    }

}
