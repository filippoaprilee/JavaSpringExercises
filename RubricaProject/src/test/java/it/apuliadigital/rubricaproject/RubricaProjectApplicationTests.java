package it.apuliadigital.rubricaproject;

import it.apuliadigital.rubricaproject.entity.Contact;
import it.apuliadigital.rubricaproject.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RubricaProjectApplicationTests {

	@Autowired
	private ContactService contactService;

	private Contact contact1;
	private Contact contact2;

    @BeforeEach
	public void setUp() {

	}

	@Test
	@Order(1)
	public void testCreateContact() {
		contact1 = new Contact();
		contact1.setNome("Mario");
		contact1.setCognome("Rossi");
		contact1.setNumeroTelefono("1234567890");
		contact1.setEmail("mariorossi@gmail.com");

		contact2 = new Contact();
		contact2.setNome("Luigi");
		contact2.setCognome("Verdi");
		contact2.setNumeroTelefono("0987654321");
		contact2.setEmail("luigiverdi@gmail.com");

		contactService.createContact(contact1);
		contactService.createContact(contact2);
	}

	@Test
	@Order(2)
	public void testGetContactById() {
		Optional<Contact> found = contactService.getContactById(contact1.getId());
		assertNotNull(found);
		assertEquals("Mario", found.get().getNome());
	}

	@Test
	@Order(3)
	public void testUpdateContact() {
		contact1.setNome("Giovanni");
		contactService.updateContact(contact1.getId(), contact1);
		Optional<Contact> found = contactService.getContactById(contact1.getId());
		assertNotNull(found);
		assertEquals("Giovanni", found.get().getNome());
	}
}
