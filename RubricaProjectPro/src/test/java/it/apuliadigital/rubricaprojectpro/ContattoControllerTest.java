package it.apuliadigital.rubricaprojectpro;

import it.apuliadigital.rubricaprojectpro.controller.ContattoController;
import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import it.apuliadigital.rubricaprojectpro.exception.ContattoException;
import it.apuliadigital.rubricaprojectpro.exception.ErrorResponse;
import it.apuliadigital.rubricaprojectpro.exception.SuccessResponse;
import it.apuliadigital.rubricaprojectpro.repository.ContattoRepository;
import it.apuliadigital.rubricaprojectpro.service.ContattoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ContattoControllerTest {

    @MockBean
    private ContattoService contattoService;

    @Autowired
    private ContattoController contattoController;

    @Test
    public void testAggiungiContatto() {
        ContattoEntity contatto = new ContattoEntity();
        contatto.setNome("Mario");
        contatto.setCognome("Rossi");

        when(contattoService.aggiungiContatto(any(ContattoEntity.class))).thenReturn(1);

        SuccessResponse<Integer> successResponse = contattoController.aggiungiContatto(contatto);

        assertEquals(HttpStatus.CREATED.value(), successResponse.getStatusCode());
        assertEquals("Contatto aggiunto con successo", successResponse.getMessage());
        assertEquals(1, successResponse.getObject());

        verify(contattoService, times(1)).aggiungiContatto(any(ContattoEntity.class));
    }

    @Test
    public void testRimuoviContatto_Success() {
        int id = 1;

        when(contattoService.rimuoviContatto(eq(id))).thenReturn(true);

        SuccessResponse<String> responseEntity = contattoController.rimuoviContatto(id);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Contatto rimosso con successo", responseEntity.getMessage());

        verify(contattoService, times(1)).rimuoviContatto(eq(id));
    }

    @Test
    public void testRimuoviContatto_NotFound() {
        int id = 2;

        when(contattoService.rimuoviContatto(eq(id))).thenReturn(false);

        SuccessResponse<String> responseEntity = contattoController.rimuoviContatto(id);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode());
        assertEquals("Contatto non trovato", responseEntity.getMessage());

        verify(contattoService, times(1)).rimuoviContatto(eq(id));
    }

    @Test
    public void testAggiornaContatto_Success() {
        int id = 1;
        ContattoEntity contatto = new ContattoEntity();
        contatto.setNome("Luigi");
        contatto.setCognome("Verdi");

        when(contattoService.aggiornaContatto(eq(id), any(ContattoEntity.class))).thenReturn(true);

        SuccessResponse<String> responseEntity = contattoController.aggiornaContatto(id, contatto);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Contatto aggiornato con successo", responseEntity.getMessage());

        verify(contattoService, times(1)).aggiornaContatto(eq(id), any(ContattoEntity.class));
    }

    @Test
    public void testAggiornaContatto_NotFound() {
        int id = 2;
        ContattoEntity contatto = new ContattoEntity();
        contatto.setNome("Paolo");
        contatto.setCognome("Bianchi");

        when(contattoService.aggiornaContatto(eq(id), any(ContattoEntity.class))).thenReturn(false);

        SuccessResponse<String> responseEntity = contattoController.aggiornaContatto(id, contatto);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode());
        assertEquals("Contatto non trovato", responseEntity.getMessage());

        verify(contattoService, times(1)).aggiornaContatto(eq(id), any(ContattoEntity.class));
    }

    @Test
    public void testTrovaContatto_Success() {
        int id = 1;
        ContattoEntity contatto = new ContattoEntity();
        contatto.setId(id);
        contatto.setNome("Giuseppe");
        contatto.setCognome("Neri");

        when(contattoService.trovaContatto(eq(id))).thenReturn(contatto);

        SuccessResponse<ContattoEntity> responseEntity = contattoController.trovaContatto(id);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Contatto trovato con successo", responseEntity.getMessage());
        assertEquals(contatto, responseEntity.getObject());

        verify(contattoService, times(1)).trovaContatto(eq(id));
    }

    @Test
    public void testTrovaContatto_NotFound() {
        int id = 2;

        when(contattoService.trovaContatto(eq(id))).thenReturn(null);

        SuccessResponse<ContattoEntity> responseEntity = contattoController.trovaContatto(id);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode());
        assertEquals("Contatto non trovato", responseEntity.getMessage());

        verify(contattoService, times(1)).trovaContatto(eq(id));
    }

    @Test
    public void testTrovaContatti() {
        ContattoEntity contatto1 = new ContattoEntity();
        contatto1.setId(1);
        contatto1.setNome("Carlo");
        contatto1.setCognome("Bianchi");

        ContattoEntity contatto2 = new ContattoEntity();
        contatto2.setId(2);
        contatto2.setNome("Maria");
        contatto2.setCognome("Verdi");

        List<ContattoEntity> contatti = Arrays.asList(contatto1, contatto2);

        when(contattoService.trovaContatti()).thenReturn(contatti);

        SuccessResponse<List<ContattoEntity>> responseEntity = contattoController.trovaContatti();

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Contatti trovati con successo", responseEntity.getMessage());
        assertEquals(contatti, responseEntity.getObject());

        verify(contattoService, times(1)).trovaContatti();
    }

    @Test
    public void testCercaContatti() {
        String nome = "Mario";
        String cognome = "Rossi";

        ContattoEntity contatto1 = new ContattoEntity();
        contatto1.setId(1);
        contatto1.setNome(nome);
        contatto1.setCognome(cognome);

        List<ContattoEntity> contatti = Arrays.asList(contatto1);

        when(contattoService.cercaContatti(eq(nome), eq(cognome))).thenReturn(contatti);

        SuccessResponse<List<ContattoEntity>> responseEntity = contattoController.cercaContatti(nome, cognome);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Contatti trovati con successo", responseEntity.getMessage());
        assertEquals(contatti, responseEntity.getObject());

        verify(contattoService, times(1)).cercaContatti(eq(nome), eq(cognome));
    }

    @Test
    public void testHandleContactsNotFound() {
        ContattoException exception = new ContattoException("Contatto non trovato");

        ErrorResponse errorResponse = contattoController.handleContactsNotFound(exception);

        assertEquals(HttpStatus.NOT_FOUND.value(), errorResponse.getStatusCode());
        assertEquals("Contatto non trovato", errorResponse.getMessage());
    }
}
