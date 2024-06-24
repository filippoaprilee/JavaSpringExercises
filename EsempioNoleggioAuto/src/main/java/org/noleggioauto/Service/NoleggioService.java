package org.noleggioauto.Service;

import org.noleggioauto.*;
import java.util.List;

public interface NoleggioService {
    void aggiungiNoleggio(Cliente cliente, Auto auto);
    Noleggio trovaNoleggio(Cliente cliente);
    void eliminaNoleggio(Cliente cliente);
    List<Noleggio> listaNoleggi();
}
