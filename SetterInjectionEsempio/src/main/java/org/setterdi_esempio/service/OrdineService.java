package org.setterdi_esempio.service;

public class OrdineService {
    private ClienteService clienteService;
    private String statoPredefinito;

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public String getStatoPredefinito() {
        return statoPredefinito;
    }

    public void setStatoPredefinito(String statoPredefinito) {
        this.statoPredefinito = statoPredefinito;
    }

    public String getOrdine() {
        return "Ordine di stato " + statoPredefinito;
    }
}
