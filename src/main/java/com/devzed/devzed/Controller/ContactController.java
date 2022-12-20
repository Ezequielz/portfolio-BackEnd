package com.devzed.devzed.Controller;

import com.devzed.devzed.Dto.dtoContact;
import com.devzed.devzed.Model.Contact;
import com.devzed.devzed.Security.Controller.Mensaje;
import com.devzed.devzed.Service.ContactService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    @Autowired ContactService contactService;

    @GetMapping("/lista")
    public ResponseEntity<List<Contact>> list() {
        List<Contact> list = contactService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoContact dtocontact) {
        if (StringUtils.isBlank(dtocontact.getEmail())) {
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtocontact.getTel())) {
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtocontact.getCity())) {
            return new ResponseEntity(new Mensaje("la ciudad es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtocontact.getGithub())) {
            return new ResponseEntity(new Mensaje("El GitHub es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtocontact.getLinkedin())) {
            return new ResponseEntity(new Mensaje("El Linkedin es obligatorio"), HttpStatus.BAD_REQUEST);
        }

   
        Contact contact = new Contact(
                dtocontact.getEmail(),
                dtocontact.getTel(),
                dtocontact.getGithub(),
                dtocontact.getLinkedin(),
                dtocontact.getCity(),
                dtocontact.getCv()
        );
        contactService.save(contact);

        return new ResponseEntity(new Mensaje("contact agregado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Contact> getById(@PathVariable("id") int id) {
        if (!contactService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Contact contact = contactService.getOne(id).get();
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoContact dtocontact) {
        // Valida si existe id
        if (!contactService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        // valida que el nombre no este en blanco
        if (StringUtils.isBlank(dtocontact.getEmail())) {
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtocontact.getTel())) {
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtocontact.getCity())) {
            return new ResponseEntity(new Mensaje("la ciudad es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtocontact.getGithub())) {
            return new ResponseEntity(new Mensaje("El GitHub es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtocontact.getLinkedin())) {
            return new ResponseEntity(new Mensaje("El Linkedin es obligatorio"), HttpStatus.BAD_REQUEST);
        }

   

        Contact contact = contactService.getOne(id).get();
        contact.setEmail(dtocontact.getEmail());
        contact.setTel(dtocontact.getTel());
        contact.setCity(dtocontact.getCity());
        contact.setGithub(dtocontact.getGithub());
        contact.setLinkedin(dtocontact.getLinkedin());
        contact.setCv(dtocontact.getCv());
        

        contactService.save(contact);

        return new ResponseEntity(new Mensaje("Contact actualizado"), HttpStatus.OK);

    }

}
