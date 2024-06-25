package org.setterdi_esempio.service;

public class OrdineService {
    private ClienteService cliente;
    private String statoPredefinito;

    public void setCliente(ClienteService cliente) {
        this.cliente = cliente;
    }

    public void setStatoPredefinito(String statoPredefinito) {
        this.statoPredefinito = statoPredefinito;
    }

    public ClienteService getCliente() {
        return cliente;
    }
}
