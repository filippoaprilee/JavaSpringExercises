package it.apuliadigital.templateesame.servicetest;

import it.apuliadigital.templateesame.repository.TemplateRepository;
import it.apuliadigital.templateesame.service.TemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Order;

@SpringBootTest
public class TemplateServiceTest {

    @Autowired
    private TemplateService templateService;

    @MockBean
    private TemplateRepository templateRepository;

    @Test
    @Order(1)
    void testAggiungiTemplate() {
        // Implementa il test per il metodo aggiungiTemplate
    }
}
