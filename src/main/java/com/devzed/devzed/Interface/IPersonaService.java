
package com.devzed.devzed.Interface;

import com.devzed.devzed.Model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> getPersonas ();
    
    public void savePersona( Persona persona );
    
    public void deletePersona( Long id );
    
    public Persona findPersona ( Long id );
    
}
