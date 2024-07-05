package it.apuliadigital.rubricaprojectpro.service.impl;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import it.apuliadigital.rubricaprojectpro.exception.ContattoException;
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
        return contattoRepository.save(cEntity).getId();
    }

    @Override
    public boolean rimuoviContatto(int id) {
        if (contattoRepository.existsById(id)) {
            contattoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean aggiornaContatto(int id, ContattoEntity cEntity) {
        if (contattoRepository.existsById(id)) {
            cEntity.setId(id);
            contattoRepository.save(cEntity);
            return true;
        }
        return false;
    }

    @Override
    public ContattoEntity trovaContatto(int id) {
        ContattoEntity contatto = contattoRepository.findById(id).orElse(null);
        if (contatto == null) {
            throw new ContattoException("Contatto non trovato");
        } else {
            return contatto;
        }
    }

    @Override
    public List<ContattoEntity> trovaContatti() {
        return (List<ContattoEntity>) contattoRepository.findAll();
    }

    @Override
    public List<ContattoEntity> cercaContatti(String nome, String cognome) {
        return contattoRepository.findByNomeAndCognome(nome, cognome);
    }
}
