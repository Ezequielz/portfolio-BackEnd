
package com.devzed.devzed.Controller;

import com.devzed.devzed.Interface.IPersonaService;
import com.devzed.devzed.Model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService personaService;
    
    @GetMapping ("/persona/all")
    public List<Persona> getPersonas (){
        return personaService.getPersonas();
    }
    
    
    @GetMapping ("/persona")
    public Persona findPersona () {
        return personaService.findPersona((long)1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/persona/new")
    public String createPersona(@RequestBody Persona persona) {
        personaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/persona/delete/{id}")
    public String deletePersona( @PathVariable Long id ) {
        personaService.deletePersona(id);
        
        return "Persona eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/persona/edit/{id}")
    public Persona editPersona( @PathVariable Long id,
                                @RequestParam("nombre") String newNombre,
                                @RequestParam("apellido") String newApellido,
                                @RequestParam("img") String newImg,
                                @RequestParam("nacionalidad") String newNacionalidad,
                                @RequestParam("email") String newEmail,
                                @RequestParam("domicilio") String newDomicilio,
                                @RequestParam("nacimiento") String newNacimiento
    ){
        
        Persona persona = personaService.findPersona(id);
        
        persona.setNombre(newNombre);   
        persona.setApellido(newApellido);
        persona.setImg(newImg);
        
        personaService.savePersona(persona);
        
        return persona;
    }
    
}
