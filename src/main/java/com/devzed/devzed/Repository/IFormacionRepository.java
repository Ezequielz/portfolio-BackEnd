
package com.devzed.devzed.Repository;

import com.devzed.devzed.Model.Formacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormacionRepository extends JpaRepository< Formacion, Integer >{
    
    public Optional<Formacion> findByTitle( String title );
    public boolean existsByTitle( String title );
}
