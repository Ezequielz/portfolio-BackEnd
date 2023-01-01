package com.devzed.devzed.Service;

import com.devzed.devzed.Model.Formacion;
import com.devzed.devzed.Repository.IFormacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormacionService {

    @Autowired
    IFormacionRepository formacionRepository;

    public List<Formacion> list() {
        return formacionRepository.findAll();
    }

    public Optional<Formacion> getOne(int id) {
        return formacionRepository.findById(id);
    }

    public Optional<Formacion> getByTitle(String title) {
        return formacionRepository.findByTitle(title);
    }

    public void save(Formacion formacion) {
        formacionRepository.save(formacion);
    }

    public void delete(int id) {
        formacionRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return formacionRepository.existsById(id);
    }

    public boolean existsByTitle(String title) {
        return formacionRepository.existsByTitle(title);
    }
}
