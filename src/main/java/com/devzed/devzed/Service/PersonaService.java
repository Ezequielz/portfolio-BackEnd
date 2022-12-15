
package com.devzed.devzed.Service;

import com.devzed.devzed.Interface.IPersonaService;
import com.devzed.devzed.Model.Persona;
import com.devzed.devzed.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired IPersonaRepository personaRepository;

    @Override
    public List<Persona> getPersonas() {
 
        return personaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }
    
}
