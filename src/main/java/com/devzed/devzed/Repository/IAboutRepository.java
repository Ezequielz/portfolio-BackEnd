
package com.devzed.devzed.Repository;

import com.devzed.devzed.Model.About;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAboutRepository extends JpaRepository<About, Integer>{
    public Optional<About> findByTitle( String title );
    public boolean existsByTitle( String title );
}
