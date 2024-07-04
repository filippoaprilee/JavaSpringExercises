package it.apuliadigital.rubricaprojectpro.service;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;

import java.util.List;

public interface ContattoService {
    public int aggiungiContatto(ContattoEntity cEntity);
    public boolean rimuoviContatto(int id);
    public boolean aggiornaContatto(int id, ContattoEntity cEntity);
    public ContattoEntity trovaContatto(int id);
    public List<ContattoEntity> trovaContatti();
    public List<ContattoEntity> cercaContatti(String nome, String cognome);

}
