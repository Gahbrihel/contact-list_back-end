package br.gov.sp.fatec.itu.contact.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.itu.contact.entities.Contact;
import br.gov.sp.fatec.itu.contact.services.ContactService;

@RestController
@RequestMapping("contact")
@CrossOrigin("https://main.d1aacktjcmxln.amplifyapp.com/contato")
public class ContactController {
    
    @Autowired
    private ContactService service;
    
    @GetMapping
    public ResponseEntity<List<Contact>> getContacts() {
        return ResponseEntity.ok(service.getContacts());
    }

    @PostMapping
    public ResponseEntity<Contact> saveContacts(@RequestBody Contact contact) {
        return ResponseEntity.created(null).body(service.saveContact(contact));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        return ResponseEntity.ok(service.updateContact(id, contactDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

}
