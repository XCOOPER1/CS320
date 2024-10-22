package contactJTest;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    // Add a contact
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            return false; // Contact with the same ID already exists
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    // Delete a contact by contactId
    public boolean deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            return false;
        }
        contacts.remove(contactId);
        return true;
    }

    // Update contact's first name
    public boolean updateFirstName(String contactId, String firstName) {
        if (contacts.containsKey(contactId)) {
            contacts.get(contactId).setFirstName(firstName);
            return true;
        }
        return false;
    }

    // Update contact's last name
    public boolean updateLastName(String contactId, String lastName) {
        if (contacts.containsKey(contactId)) {
            contacts.get(contactId).setLastName(lastName);
            return true;
        }
        return false;
    }

    // Update contact's phone number
    public boolean updatePhoneNumber(String contactId, String phoneNumber) {
        if (contacts.containsKey(contactId)) {
            contacts.get(contactId).setPhone(phoneNumber);
            return true;
        }
        return false;
    }

    // Update contact's address
    public boolean updateAddress(String contactId, String address) {
        if (contacts.containsKey(contactId)) {
            contacts.get(contactId).setAddress(address);
            return true;
        }
        return false;
    }

    // Get contact by ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
