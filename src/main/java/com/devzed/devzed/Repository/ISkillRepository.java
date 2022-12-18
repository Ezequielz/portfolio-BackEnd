
package com.devzed.devzed.Repository;

import com.devzed.devzed.Model.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISkillRepository extends JpaRepository<Skill, Integer>{
    Optional<Skill> findByNombre( String nombre );
    public boolean existsByNombre( String nombre );
}
