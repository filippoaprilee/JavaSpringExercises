package org.annotationeautowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="ordine")
public class OrdineService {
    private ClienteService cliente;
    private ProdottoService prodotto;

    @Autowired
    public void recuperaService(ClienteService cliente, ProdottoService prodotto) {
        this.cliente = cliente;
        this.prodotto = prodotto;
    }

    public OrdineService() {
        super();
    }

    public String sayHello() {
        return "ciao sono un ordine del cliente " + cliente.getCliente(124) + " e del prodotto " + prodotto.getProdotto(2);
    }

    public void stampaClienti() {
        cliente.tuttiClienti().forEach((id, nome) -> System.out.println("id: " + id + " nome: " + nome));
    }
}
