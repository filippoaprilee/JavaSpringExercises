package org.noleggioauto.Service;

import org.noleggioauto.Cliente;
import java.util.List;

public interface ClienteService {
    void aggiungiCliente(Cliente cliente);
    Cliente trovaCliente(int id);
    void eliminaCliente(int id);
    List<Cliente> listaClienti();
}