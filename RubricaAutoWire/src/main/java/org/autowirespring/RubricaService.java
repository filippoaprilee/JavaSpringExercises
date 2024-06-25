package org.autowirespring;

public class RubricaService {
    private MessaggiService messaggiService;
    private String nome;

    public RubricaService() {
        super();
    }

    public void setMessaggiService(MessaggiService messaggiService) {
        this.messaggiService = messaggiService;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMessaggi(long idUser) {
        return messaggiService.getMessaggi(idUser);
    }

    public MessaggiService getMessaggiService() {
        return messaggiService;
    }

    public void mostraInfo() {
        System.out.println("RubricaService: " + nome);
        messaggiService.mostraInfo();
    }

}
