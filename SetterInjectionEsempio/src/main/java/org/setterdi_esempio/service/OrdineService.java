package org.setterdi_esempio.service;

public class OrdineService {
    private ClienteService cliente;
    private String statoPredefinito;

    public ClienteService getCliente() {
        return cliente;
    }

    public void setCliente(ClienteService cliente) {
        this.cliente = cliente;
    }

    public String getStatoPredefinito() {
        return statoPredefinito;
    }

    public void setStatoPredefinito(String statoPredefinito) {
        this.statoPredefinito = statoPredefinito;
    }

    @Override
    public String toString() {
        return "OrdineService [cliente=" + cliente + ", statoPredefinito=" + statoPredefinito + "]";
    }
}
