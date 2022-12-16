
package com.devzed.devzed.Service;

import com.devzed.devzed.Model.Project;
import com.devzed.devzed.Repository.IProjectRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectService {
    @Autowired IProjectRepository projectRepository;
    
    public List<Project> list(){       
        return projectRepository.findAll();
    }
    
    public Optional<Project> getOne(int id) {
        return projectRepository.findById(id);
    }
    
    public Optional<Project> getByTitle(String title){
        return projectRepository.findByTitle(title);
    }
    
    public void save( Project project ) {
        projectRepository.save(project);
    }
    
    public void delete(int id){
        projectRepository.deleteById(id);
    }
    
    public boolean existsById (int id){
        return projectRepository.existsById(id);
    }
    
    public boolean existsByTitle (String title){
        return projectRepository.existsByTitle(title);
    }
}
