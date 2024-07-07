package it.apuliadigital.bibliotecaproject.servicetest;

import it.apuliadigital.bibliotecaproject.entity.LogEntity;
import it.apuliadigital.bibliotecaproject.repository.LogRepository;
import it.apuliadigital.bibliotecaproject.service.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LogServiceTest {

    @Autowired
    LogService logService;

    @MockBean
    LogRepository logRepository;

    @Test
    void testSaveLog() {
        // Creazione di un esempio di LogEntity
        String path = "/book/search";
        String message = "Ricerca libri con filtri - titolo: Java Programming, autore: John Doe, genere: Thriller," +
                " isbn: 1234567890, lingua: English, editore: ABC Publisher, data pubblicazione: 1990-06-01";
        LocalDateTime timestamp = LocalDateTime.now();
        LogEntity logEntity = new LogEntity(path, message, timestamp);

        /* Simuliamo il comportamento del repository quando viene chiamato il metodo save con qualsiasi LogEntity.
        Utilizziamo any(LogEntity.class) per accettare qualsiasi istanza di LogEntity come argomento.
        Questo approccio ci permette di configurare il mock del repository in modo che restituisca logEntity
        indipendentemente dai dettagli specifici dell'istanza, inclusi i millisecondi del timestamp.*/
        when(logRepository.save(any(LogEntity.class))).thenReturn(logEntity);

        // Chiamiamo il metodo del servizio per salvare il log
        logService.saveLog(path, message);

        // Verifica che il metodo save del repository sia stato chiamato con un qualsiasi LogEntity
        verify(logRepository).save(any(LogEntity.class));
    }
}
