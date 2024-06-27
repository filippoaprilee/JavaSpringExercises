package it.apuliadigital.noleggioauto.service.impl;

import it.apuliadigital.noleggioauto.model.Veicolo;
import it.apuliadigital.noleggioauto.service.VeicoloService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeicoloServiceImpl implements VeicoloService {
    private List<Veicolo> veicoli = new ArrayList<>();
    private Long ultimoId = 0L;

    @Override
    public List<Veicolo> trovaTuttiIVeicoli() {
        return veicoli;
    }

    @Override
    public Veicolo trovaVeicoloPerId(Long id) {
        return veicoli.stream()
                .filter(veicolo -> veicolo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Veicolo trovaVeicoloPerTarga(String targa) {
        return veicoli.stream()
                .filter(veicolo -> veicolo.getTarga().equals(targa))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void aggiungiVeicolo(Veicolo veicolo) {
        veicolo.setId(++ultimoId);
        veicoli.add(veicolo);
    }

    @Override
    public void modificaVeicolo(Veicolo veicolo) {
        Veicolo veicoloDaModificare = trovaVeicoloPerId(veicolo.getId());
        if (veicoloDaModificare != null) {
            veicoloDaModificare.setModello(veicolo.getModello());
            veicoloDaModificare.setMarca(veicolo.getMarca());
            veicoloDaModificare.setTarga(veicolo.getTarga());
            veicoloDaModificare.setAnno(veicolo.getAnno());
            veicoloDaModificare.setTipo(veicolo.getTipo());
            veicoloDaModificare.setDisponibilita(veicolo.isDisponibilita());
            veicoloDaModificare.setPrezzoGiornaliero(veicolo.getPrezzoGiornaliero());
        }
    }

    @Override
    public void eliminaVeicolo(Long id) {
        veicoli = veicoli.stream()
                .filter(veicolo -> !veicolo.getId().equals(id))
                .toList();
    }
}
