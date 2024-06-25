package org.annotationeautowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="ordine")
public class OrdineService {
    private ClienteService cliente;

    @Autowired
    public OrdineService(ClienteService cliente) {
        super();
        this.cliente = cliente;
    }

    public OrdineService() {
        super();
    }

    public String sayHello() {
        return "ciao sono un ordine del cliente " + cliente.getCliente(124);
    }

    public void stampaClienti() {
        cliente.tuttiClienti().forEach((id, nome) -> System.out.println("id: " + id + " nome: " + nome));
    }
}
