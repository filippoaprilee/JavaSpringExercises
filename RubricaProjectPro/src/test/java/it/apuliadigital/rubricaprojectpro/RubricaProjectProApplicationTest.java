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
class RubricaProjectProApplicationTests {

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

        // Verifica che il metodo del servizio ritorni 1
        assertEquals(0, result);

        // Verifica che il metodo save sia stato chiamato esattamente una volta con il contatto specificato
        verify(contattoRepository).save(contatto);
    }
}


