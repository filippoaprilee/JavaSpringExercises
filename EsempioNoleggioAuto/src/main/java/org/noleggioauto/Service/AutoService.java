package org.noleggioauto.Service;

import org.noleggioauto.*;
import java.util.List;

public interface AutoService {
    public void aggiungiAuto(Auto auto);
    public Auto trovaAuto(String targa);
    public List<Auto> trovaAutoByModello(String modello);
    public void eliminaAuto(String targa);
    public List<Auto> listaAuto(StatoPrenotazione stato);
}
