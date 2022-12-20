package com.devzed.devzed.Repository;

import com.devzed.devzed.Model.Contact;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Integer> {

    public Optional<Contact> findByEmail(String email);

    public boolean existsByEmail(String email);
}
