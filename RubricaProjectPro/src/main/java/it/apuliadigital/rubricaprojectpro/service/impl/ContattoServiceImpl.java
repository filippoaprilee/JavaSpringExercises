package it.apuliadigital.rubricaprojectpro.service.impl;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import it.apuliadigital.rubricaprojectpro.repository.ContattoRepository;
import it.apuliadigital.rubricaprojectpro.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContattoServiceImpl implements ContattoService {

    @Autowired
    private ContattoRepository contattoRepository;

    @Override
    public int aggiungiContatto(ContattoEntity cEntity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean rimuoviContatto(int id) {
        return false;
    }

    @Override
    public boolean aggiornaContatto(int id, ContattoEntity cEntity) {
        return false;
    }

    @Override
    public ContattoEntity trovaContatto(int id) {
        return null;
    }

    @Override
    public List<ContattoEntity> trovaContatti() {
        return List.of();
    }

    @Override
    public List<ContattoEntity> cercaContatti(String nome, String cognome) {
        return List.of();
    }
}
