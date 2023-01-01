
package com.devzed.devzed.Repository;

import com.devzed.devzed.Model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository< Experiencia, Integer > {
    public Optional<Experiencia> findByTitle( String title );
    public boolean existsByTitle( String title );
}
