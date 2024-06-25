package org.setterdi_esempio.service;

public class FatturaService {
    private ClienteService clienteService;
    private OrdineService ordineService;

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public OrdineService getOrdineService() {
        return ordineService;
    }

    public void setOrdineService(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    public void stampaFattura() {
        ClienteService cliente = clienteService;
        OrdineService ordine = ordineService;

        System.out.println("Fattura");
        System.out.println(clienteService.clienti());
        System.out.println(ordineService.getOrdine());
    }

}
