package br.gov.sp.fatec.itu.contact.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.itu.contact.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
