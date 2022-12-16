
package com.devzed.devzed.Repository;

import com.devzed.devzed.Model.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Integer>{
    public Optional<Project> findByTitle( String title );
    public boolean existsByTitle( String title );
}
