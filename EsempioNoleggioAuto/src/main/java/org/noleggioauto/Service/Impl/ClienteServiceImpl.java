package org.noleggioauto.Service.Impl;

import org.noleggioauto.*;
import org.noleggioauto.Service.ClienteService;

import java.util.*;

public class ClienteServiceImpl implements ClienteService {
    private Map<Integer, Cliente> clienteMap = new HashMap<>();

    @Override
    public void aggiungiCliente(Cliente cliente) {
        clienteMap.put(cliente.getId(), cliente);
        System.out.println("Il cliente " + cliente.getNome() + " " + cliente.getCognome() + " è stato aggiunto con successo.");
    }

    @Override
    public Cliente trovaCliente(int id) {
        return clienteMap.get(id);
    }

    @Override
    public void eliminaCliente(int id) {
        clienteMap.remove(id);
    }

    @Override
    public List<Cliente> listaClienti() {
        return new ArrayList<>(clienteMap.values());
    }
}
