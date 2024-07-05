package it.apuliadigital.rubricaprojectpro;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import it.apuliadigital.rubricaprojectpro.repository.ContattoRepository;
import it.apuliadigital.rubricaprojectpro.service.ContattoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class RubricaProjectProApplicationTest {

    // Inietto il ContattoService per testare i metodi del servizio
    @Autowired
    ContattoService contattoService;

    // Mock del repository per simulare il comportamento del database
    @MockBean
    ContattoRepository contattoRepository;

    @Test
    @Order(1)
    void testAggiungiContatto() {
        // Crea un contatto di prova
        ContattoEntity contatto = new ContattoEntity("Mario", "Rossi", "1234567890", "mail");

        // Mocka il comportamento di save nel repository
        when(contattoRepository.save(contatto)).thenReturn(contatto);

        // Chiamata al metodo del servizio
        int result = contattoService.aggiungiContatto(contatto);

        // Verifica che il metodo del servizio ritorni il valore inserito
        assertEquals(0, result);

        // Verifica che il metodo save sia stato chiamato esattamente una volta con il contatto specificato
        verify(contattoRepository).save(contatto);
    }

    @Test
    @Order(2)
    void testRimuoviContatto() {
        int contattoId = 1;

        // Setup: Assume che il contatto esista
        when(contattoRepository.existsById(contattoId)).thenReturn(true);

        // Azione: Tentativo di rimuovere il contatto
        boolean result = contattoService.rimuoviContatto(contattoId);

        // Verifica: Il contatto è stato rimosso con successo
        assertEquals(true, result);
        verify(contattoRepository).deleteById(contattoId);

        // Setup: Assume che il contatto non esista
        when(contattoRepository.existsById(contattoId)).thenReturn(false);

        // Azione: Tentativo di rimuovere un contatto non esistente
        result = contattoService.rimuoviContatto(contattoId);

        // Verifica: Il metodo ritorna false poiché il contatto non esiste
        assertEquals(false, result);
        // Verifica che deleteById non sia stato chiamato per un contatto non esistente
        verify(contattoRepository).deleteById(contattoId);
    }

    @Test
    @Order(3)
    void testAggiornaContatto() {
        int contattoId = 1;
        ContattoEntity updatedContatto = new ContattoEntity("Luigi", "Bianchi", "0987654321", "email@update.com");
        updatedContatto.setId(contattoId); // Set ID to simulate the entity that would be updated

        // Setup: Assume che il contatto esista
        when(contattoRepository.existsById(contattoId)).thenReturn(true);
        when(contattoRepository.save(any(ContattoEntity.class))).thenReturn(updatedContatto);

        // Azione: Tentativo di aggiornare il contatto
        boolean result = contattoService.aggiornaContatto(contattoId, updatedContatto);

        // Verifica: Il contatto è stato aggiornato con successo
        assertEquals(true, result);
        verify(contattoRepository).save(updatedContatto);

        // Setup: Si assume che il contatto non esista
        when(contattoRepository.existsById(contattoId)).thenReturn(false);

        // Azione: Tentativo di aggiornare un contatto non esistente
        result = contattoService.aggiornaContatto(contattoId, updatedContatto);

        // Verifica: Il metodo ritorna false poiché il contatto non esiste
        assertEquals(false, result);
    }

    @Test
    @Order(4)
    void testTrovaContatto() {
        int contattoId = 1;
        ContattoEntity expectedContatto = new ContattoEntity("Mario", "Rossi", "1234567890", "mail@example.com");
        expectedContatto.setId(contattoId);

        // Setup: Si assume che il contatto esista
        when(contattoRepository.findById(contattoId)).thenReturn(Optional.of(expectedContatto));

        // Azione: Tentativo di trovare il contatto
        ContattoEntity result = contattoService.trovaContatto(contattoId);

        // Verifica: Viene restituito il contatto corretto
        assertEquals(expectedContatto, result);

        // Setup: Si assume che il contatto non esista
        when(contattoRepository.findById(contattoId)).thenReturn(Optional.empty());

        // Azione: Tentativo di trovare un contatto non esistente
        result = contattoService.trovaContatto(contattoId);

        // Verifica: Non viene restituito alcun contatto
        assertNull(result);
    }

    @Test
    @Order(5)
    void trovaContatti() {
        // Crea una lista di contatti attesi come risultato
        List<ContattoEntity> expectedContatti = List.of(
                new ContattoEntity("Mario", "Rossi", "1234567890", "mail@example.com"),
                new ContattoEntity("Luigi", "Bianchi", "0987654321", "email@update.com")
        );

        // Setup: Simula il comportamento del metodo findAll per restituire la lista di contatti attesi
        when(contattoRepository.findAll()).thenReturn(expectedContatti);

        // Azione: Recupera la lista di contatti tramite il metodo trovaContatti
        List<ContattoEntity> result = contattoService.trovaContatti();

        // Verifica: Confronta la lista di contatti restituita con quella attesa
        assertEquals(expectedContatti, result);

        // Verifica che il metodo findAll sia stato chiamato
        verify(contattoRepository).findAll();
    }

    @Test
    @Order(6)
    void testCercaContatti() {
        String nome = "Mario";
        String cognome = "Rossi";
        // Crea una lista di contatti attesi come risultato
        List<ContattoEntity> expectedContatti = List.of(
                new ContattoEntity(nome, cognome, "1234567890", "mail@example.com")
        );

        // Setup: Simula il comportamento del metodo findByNomeAndCognome per restituire la lista di contatti attesi
        when(contattoRepository.findByNomeAndCognome(nome, cognome)).thenReturn(expectedContatti);

        // Azione: Recupera la lista di contatti tramite il metodo cercaContatti
        List<ContattoEntity> result = contattoService.cercaContatti(nome, cognome);

        // Verifica: Confronta la lista di contatti restituita con quella attesa
        assertEquals(expectedContatti, result);

        // Verifica che il metodo findByNomeAndCognome sia stato chiamato con i parametri corretti
        verify(contattoRepository).findByNomeAndCognome(nome, cognome);
    }
}


