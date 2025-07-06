package br.gov.sp.fatec.itu.contact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.gov.sp.fatec.itu.contact.entities.Contact;
import br.gov.sp.fatec.itu.contact.services.ContactService;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    
    @Autowired
    private ContactService service;
    
    // Adiciona endpoint OPTIONS para cada rota
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .header("Access-Control-Max-Age", "3600")
                .build();
    }
    
    @GetMapping
    public ResponseEntity<List<Contact>> getContacts() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(service.getContacts());
    }

    @PostMapping
    public ResponseEntity<Contact> saveContacts(@RequestBody Contact contact) {
        return ResponseEntity.created(null)
                .header("Access-Control-Allow-Origin", "*")
                .body(service.saveContact(contact));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(service.updateContact(id, contactDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
        return ResponseEntity.noContent()
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
}
