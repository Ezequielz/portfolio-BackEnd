package com.devzed.devzed.Service;

import com.devzed.devzed.Model.Contact;
import com.devzed.devzed.Repository.IContactRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired IContactRepository contactRepository;

    public List<Contact> list() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getOne(int id) {
        return contactRepository.findById(id);
    }

    public Optional<Contact> getByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public void delete(int id) {
        contactRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return contactRepository.existsById(id);
    }

    public boolean existsByEmail(String email) {
        return contactRepository.existsByEmail(email);
    }
}
