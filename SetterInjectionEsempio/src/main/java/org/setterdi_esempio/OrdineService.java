package org.setterdi_esempio;

public class OrdineService {
    private ClienteService cliente;
    private String statoPredefinito;

    public void setCliente(ClienteService cliente) {
        this.cliente = cliente;
    }

    public void setStatoPredefinito(String statoPredefinito) {
        this.statoPredefinito = statoPredefinito;
    }

}
