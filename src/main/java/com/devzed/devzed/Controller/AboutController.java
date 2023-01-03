package com.devzed.devzed.Controller;

import com.devzed.devzed.Dto.dtoAbout;
import com.devzed.devzed.Model.About;
import com.devzed.devzed.Security.Controller.Mensaje;
import com.devzed.devzed.Service.AboutService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
@CrossOrigin(origins = "https://devzedportfolio.web.app")
public class AboutController {

    @Autowired
    AboutService aboutService;

    @GetMapping("/lista")
    public ResponseEntity<List<About>> list() {
        List<About> list = aboutService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAbout dtoabout) {
        if (StringUtils.isBlank(dtoabout.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        About about = new About(
                dtoabout.getTitle(),
                dtoabout.getInfo()
        );
        aboutService.save(about);

        return new ResponseEntity(new Mensaje("about agregado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id") int id) {
        if (!aboutService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        About about = aboutService.getOne(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAbout dtoabout) {
        // Valida si existe id
        if (!aboutService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        // valida que el nombre no este en blanco
        if (StringUtils.isBlank(dtoabout.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoabout.getInfo())) {
            return new ResponseEntity(new Mensaje("lLa info es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        About about = aboutService.getOne(id).get();
        about.setTitle(dtoabout.getTitle());
        about.setInfo(dtoabout.getInfo());

        aboutService.save(about);

        return new ResponseEntity(new Mensaje("About actualizado"), HttpStatus.OK);

    }

}
