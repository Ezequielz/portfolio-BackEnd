package com.devzed.devzed.Controller;

import com.devzed.devzed.Dto.dtoFormacion;
import com.devzed.devzed.Model.Formacion;
import com.devzed.devzed.Security.Controller.Mensaje;
import com.devzed.devzed.Service.FormacionService;
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
@RequestMapping("/formacion")
@CrossOrigin(origins = {"http://localhost:4200", "https://backend-argentina-programa.onrender.com"})
public class FormacionController {

    @Autowired
    FormacionService formacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Formacion>> list() {
        List<Formacion> list = formacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoFormacion dtoFor) {
        if (StringUtils.isBlank(dtoFor.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (formacionService.existsByTitle(dtoFor.getTitle())) {
            return new ResponseEntity(new Mensaje("Esa formacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        Formacion formacion = new Formacion(dtoFor.getFecha(),dtoFor.getTitle(),dtoFor.getSubtitle(),dtoFor.getInfo());
        formacionService.save(formacion);

        return new ResponseEntity(new Mensaje("Formacion agregado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Formacion> getById(@PathVariable("id") int id) {
        if (!formacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Formacion formacion = formacionService.getOne(id).get();
        return new ResponseEntity(formacion, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoFormacion dtoFor) {
        // Valida si existe id
        if (!formacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        // valida que el titulo no este en blanco
        if (StringUtils.isBlank(dtoFor.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //valida que no repita el titulo
        if (formacionService.existsByTitle(dtoFor.getTitle()) && formacionService.getByTitle(dtoFor.getTitle()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese titulo de formacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        Formacion formacion = formacionService.getOne(id).get();
        formacion.setFecha(dtoFor.getFecha());
        formacion.setTitle(dtoFor.getTitle());
        formacion.setSubtitle(dtoFor.getSubtitle());
        formacion.setInfo(dtoFor.getInfo());


        formacionService.save(formacion);

        return new ResponseEntity(new Mensaje("Formacion actualizado"), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Valida si existe id
        if (!formacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        formacionService.delete(id);

        return new ResponseEntity(new Mensaje("Formacion eliminado"), HttpStatus.OK);

    }

}
