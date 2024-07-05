package it.apuliadigital.rubricaprojectpro;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import it.apuliadigital.rubricaprojectpro.repository.ContattoRepository;
import it.apuliadigital.rubricaprojectpro.service.ContattoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class RubricaProjectProApplicationTest {

    @Autowired
    ContattoService contattoService;

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

        // Setup: Assume the contact exists
        when(contattoRepository.existsById(contattoId)).thenReturn(true);

        // Action: Attempt to remove the contact
        boolean result = contattoService.rimuoviContatto(contattoId);

        // Assert: The contact was successfully removed
        assertEquals(true, result);
        verify(contattoRepository).deleteById(contattoId);

        // Setup: Assume the contact does not exist
        when(contattoRepository.existsById(contattoId)).thenReturn(false);

        // Action: Attempt to remove a non-existing contact
        result = contattoService.rimuoviContatto(contattoId);

        // Assert: The method returns false as the contact does not exist
        assertEquals(false, result);
        // Verify deleteById was not called for a non-existing contact
        verify(contattoRepository).deleteById(contattoId);
    }
}


