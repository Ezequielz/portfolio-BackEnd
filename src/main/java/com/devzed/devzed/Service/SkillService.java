
package com.devzed.devzed.Service;

import com.devzed.devzed.Model.Skill;
import com.devzed.devzed.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillService {
    @Autowired ISkillRepository skillRepository;
    
    public List<Skill> list(){
        return skillRepository.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return skillRepository.findById(id);
    }
    
    public Optional<Skill> getByNombre( String nombre ){
        return skillRepository.findByNombre(nombre);
    }
    
    public void save(Skill skill){
        skillRepository.save(skill);
    }
    
    public void delete(int id){
        skillRepository.deleteById(id);
    }
    
    public boolean existsById( int id ){
        return skillRepository.existsById(id);
    }
    
    public boolean existsByNombre( String nombre ){
       return skillRepository.existsByNombre(nombre);
    }
}
