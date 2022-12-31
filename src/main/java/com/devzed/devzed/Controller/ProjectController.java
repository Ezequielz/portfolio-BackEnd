package com.devzed.devzed.Controller;

import com.devzed.devzed.Dto.dtoProject;
import com.devzed.devzed.Model.Project;
import com.devzed.devzed.Security.Controller.Mensaje;
import com.devzed.devzed.Service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
@CrossOrigin(origins = {"http://localhost:4200", "https://backend-argentina-programa.onrender.com"})
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/lista")
    public ResponseEntity<List<Project>> list() {
        List<Project> list = projectService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProject dtoPro) {
        if (StringUtils.isBlank(dtoPro.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (projectService.existsByTitle(dtoPro.getTitle())) {
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Project project = new Project(dtoPro.getTitle(), dtoPro.getDescripcion(), dtoPro.getImg(), dtoPro.getGiturl(), dtoPro.getWeburl());
        projectService.save(project);

        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id) {
        if (!projectService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Project project = projectService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProject dtoPro) {
        // Valida si existe id
        if (!projectService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        // valida que el titulo no este en blanco
        if (StringUtils.isBlank(dtoPro.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //valida que no repita el titulo
        if (projectService.existsByTitle(dtoPro.getTitle()) && projectService.getByTitle(dtoPro.getTitle()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese titulo de proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Project project = projectService.getOne(id).get();
        project.setTitle(dtoPro.getTitle());
        project.setDescripcion(dtoPro.getDescripcion());
        project.setImg(dtoPro.getImg());
        project.setGiturl(dtoPro.getGiturl());
        project.setWeburl(dtoPro.getWeburl());

        projectService.save(project);

        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Valida si existe id
        if (!projectService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        projectService.delete(id);

        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);

    }
}
