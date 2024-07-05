package it.apuliadigital.rubricaprojectpro;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import it.apuliadigital.rubricaprojectpro.repository.ContattoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
public class ControllerRepositoryTest {

    @Autowired
    private ContattoRepository contattoRepository;

    private ContattoEntity contatto; // Contatto da creare una sola volta

    @BeforeEach
    void setUp() {
        // Crea il contatto una sola volta
        contatto = new ContattoEntity();
        contatto.setNome("Mario");
        contatto.setCognome("Rossi");
        contattoRepository.save(contatto);
    }

    @Test
    void testFindByNomeAndCognome() {
        // Esegui il test
        List<ContattoEntity> result = contattoRepository.findByNomeAndCognome("Mario", "Rossi");

        // Verifica che la lista dei risultati non sia vuota
        assertNotEquals(0, result.size(), "La lista non dovrebbe essere vuota per findByNomeAndCognome");

        // Opzionalmente, verifica valori specifici
        assertEquals("Mario", result.get(0).getNome(), "Il primo risultato dovrebbe avere nome 'Mario'");
        assertEquals("Rossi", result.get(0).getCognome(), "Il primo risultato dovrebbe avere cognome 'Rossi'");
    }

    @Test
    void testFindByNome() {
        List<ContattoEntity> result = contattoRepository.findByNome("Mario");
        assertNotEquals(0, result.size(), "La lista non dovrebbe essere vuota per findByNome");
        // Opzionalmente, verifica valori specifici o condizioni
        assertEquals("Mario", result.get(0).getNome(), "Il primo risultato dovrebbe avere nome 'Mario'");
    }

    @Test
    void testFindByCognome() {
        List<ContattoEntity> result = contattoRepository.findByCognome("Rossi");
        assertNotEquals(0, result.size(), "La lista non dovrebbe essere vuota per findByCognome");
        // Opzionalmente, verifica valori specifici o condizioni
        assertEquals("Rossi", result.get(0).getCognome(), "Il primo risultato dovrebbe avere cognome 'Rossi'");
    }

    @Test
    void testFindByNomeOrCognome() {
        List<ContattoEntity> result = contattoRepository.findByNomeOrCognome("Mario", "Rossi");
        assertNotEquals(0, result.size(), "La lista non dovrebbe essere vuota per findByNomeOrCognome");
        // Opzionalmente, verifica valori specifici o condizioni
        assertEquals("Mario", result.get(0).getNome(), "Il primo risultato dovrebbe avere nome 'Mario'");
        assertEquals("Rossi", result.get(0).getCognome(), "Il primo risultato dovrebbe avere cognome 'Rossi'");
    }
}
