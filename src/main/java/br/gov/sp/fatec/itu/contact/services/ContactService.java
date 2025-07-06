package br.gov.sp.fatec.itu.contact.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.itu.contact.entities.Contact;
import br.gov.sp.fatec.itu.contact.repositories.ContactRepository;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository repository;

    public List<Contact> getContacts(){
        return repository.findAll();
    }

    public Contact saveContact(Contact contact){
        return repository.save(contact);
    }

    public Contact updateContact(Long id, Contact contactDetails) {
        Contact contact = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com o id: " + id));
        contact.setName(contactDetails.getName());
        contact.setPhone(contactDetails.getPhone());
        contact.setEmail(contactDetails.getEmail());
        contact.setCategory(contactDetails.getCategory());
        contact.setFavorite(contactDetails.isFavorite()); 
        
        return repository.save(contact);
    }

    public void deleteContact(Long id) {
        Contact contact = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com o id: " + id));
        repository.delete(contact);
    }
}
