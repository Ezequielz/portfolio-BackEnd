package com.devzed.devzed.Service;

import com.devzed.devzed.Model.Persona;
import com.devzed.devzed.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired IPersonaRepository personaRepository;

    public List<Persona> list() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return personaRepository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    public void delete(int id) {
        personaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return personaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return personaRepository.existsByNombre(nombre);
    }

}
