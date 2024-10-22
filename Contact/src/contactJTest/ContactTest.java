package contactJTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testContactCreationValid() {
        // Test valid contact creation
        Contact contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        assertEquals("321", contact.getContactId());
        assertEquals("Reginald", contact.getFirstName());
        assertEquals("Cooper", contact.getLastName());
        assertEquals("9363333845", contact.getPhone());
        assertEquals("321 Elkhart Rd", contact.getAddress());
    }

    @Test
    void testContactCreationInvalidContactId() {
        // Test contact ID cannot be null or longer than 10 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        });
        assertEquals("Invalid Contact ID", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        });
        assertEquals("Invalid Contact ID", exception.getMessage());
    }

    @Test
    void testFirstNameValidation() {
        // Test first name cannot be null or longer than 10 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("321", null, "Cooper", "9363333845", "321 Elkhart Rd");
        });
        assertEquals("Invalid First Name", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("321", "Reginaldddd", "Cooper", "9363333845", "321 Elkhart Rd");
        });
        assertEquals("Invalid First Name", exception.getMessage());
    }

    @Test
    void testLastNameValidation() {
        // Test last name cannot be null or longer than 10 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("321", "Reginald", null, "9363333845", "321 Elkhart Rd");
        });
        assertEquals("Invalid Last Name", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("321", "Reginald", "Coopercooper", "9363333845", "321 Elkhart Rd");
        });
        assertEquals("Invalid Last Name", exception.getMessage());
    }

    @Test
    void testPhoneValidation() {
        // Test phone must be exactly 10 digits
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("321", "Reginald", "Cooper", "93633338", "321 Elkhart Rd");
        });
        assertEquals("Phone must be exactly 10 digits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("321", "Reginald", "Cooper", "93633338457", "321 Elkhart Rd");
        });
        assertEquals("Phone must be exactly 10 digits", exception.getMessage());
    }

    @Test
    void testAddressValidation() {
        // Test address cannot be null or longer than 30 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("321", "Reginald", "Cooper", "9363333845", null);
        });
        assertEquals("Address must be no longer than 30 characters", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("321", "Reginald", "Cooper", "9363333845", "123456789012345678901234567890123");
        });
        assertEquals("Address must be no longer than 30 characters", exception.getMessage());
    }

    @Test
    void testFirstNameUpdateValid() {
        // Test updating first name with valid data
        Contact contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        contact.setFirstName("Ashley");
        assertEquals("Ashley", contact.getFirstName());
    }

    @Test
    void testFirstNameUpdateInvalid() {
        // Test first name update fails with invalid data
        Contact contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        contact.setFirstName("Ashley");
        contact.setFirstName("Reginaldddddd"); // Invalid update should be ignored
        assertEquals("Ashley", contact.getFirstName()); // Value should not change
    }

    @Test
    void testLastNameUpdateValid() {
        // Test updating last name with valid data
        Contact contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testLastNameUpdateInvalid() {
        // Test last name update fails with invalid data
        Contact contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        contact.setLastName("Smith");
        contact.setLastName("Coopercooper"); // Invalid update should be ignored
        assertEquals("Smith", contact.getLastName()); // Value should not change
    }

    @Test
    void testPhoneUpdateValid() {
        // Test updating phone with valid data
        Contact contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        contact.setPhone("8325551234");
        assertEquals("8325551234", contact.getPhone());
    }

    @Test
    void testPhoneUpdateInvalid() {
        // Test phone update fails with invalid data
        Contact contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        contact.setPhone("8325551234");
        contact.setPhone("936"); // Invalid update should be ignored
        assertEquals("8325551234", contact.getPhone()); // Value should not change
    }

    @Test
    void testAddressUpdateValid() {
        // Test updating address with valid data
        Contact contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        contact.setAddress("987 Maple St");
        assertEquals("987 Maple St", contact.getAddress());
    }

    @Test
    void testAddressUpdateInvalid() {
        // Test address update fails with invalid data
        Contact contact = new Contact("321", "Reginald", "Cooper", "9363333845", "321 Elkhart Rd");
        contact.setAddress("987 Maple St");
        contact.setAddress("12345678901234567890123456789012345"); // Invalid update should be ignored
        assertEquals("987 Maple St", contact.getAddress()); // Value should not change
    }
}
