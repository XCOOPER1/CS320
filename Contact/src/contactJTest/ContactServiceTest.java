package contactJTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        contactService.addContact(contact);
    }

    @Test
    public void testAddContact() {
        assertFalse(contactService.addContact(contact)); // Duplicate contact ID
        Contact newContact = new Contact("322", "Ashley", "Marshelle", "8325551234", "987 Maple St");
        assertTrue(contactService.addContact(newContact));
    }

    @Test
    public void testDeleteContact() {
        assertTrue(contactService.deleteContact("321"));
        assertFalse(contactService.deleteContact("999")); // Non-existing ID
    }

    @Test
    public void testUpdateFirstName() {
        assertTrue(contactService.updateFirstName("321", "John"));
        assertEquals("John", contactService.getContact("321").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        assertTrue(contactService.updateLastName("321", "Doe"));
        assertEquals("Doe", contactService.getContact("321").getLastName());
    }

    @Test
    public void testUpdatePhoneNumber() {
        assertTrue(contactService.updatePhoneNumber("321", "8325551234"));
        assertEquals("8325551234", contactService.getContact("321").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        assertTrue(contactService.updateAddress("321", "987 Maple St"));
        assertEquals("987 Maple St", contactService.getContact("321").getAddress());
    }
}
