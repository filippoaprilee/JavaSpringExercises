package it.apuliadigital.rubricaproject;

import it.apuliadigital.rubricaproject.entity.Contact;
import it.apuliadigital.rubricaproject.repository.ContactRepository;
import it.apuliadigital.rubricaproject.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class RubricaProjectApplicationTests {

	@Autowired
	private ContactService contactService;

	@MockBean
	ContactRepository contactRepository;

    @BeforeEach
	public void setUp() {

	}

	@Test
	@Order(1)
	void testAggiungiContatto() {
		// Crea un contatto di prova
		Contact contatto = new Contact("Mario", "Rossi", "1234567890", "mail");

		// Mocka il comportamento di save nel repository
		when(contactRepository.save(contatto)).thenReturn(contatto);

		// Chiamata al metodo del servizio
		Contact result = contactService.createContact(contatto);

		// Verifica che il metodo del servizio ritorni 1
		assertEquals(contatto, result);

		// Verifica che il metodo save sia stato chiamato esattamente una volta con il contatto specificato
		verify(contactRepository).save(contatto);
	}
}
