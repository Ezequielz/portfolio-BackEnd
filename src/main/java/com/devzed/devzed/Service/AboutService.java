package com.devzed.devzed.Service;

import com.devzed.devzed.Model.About;
import com.devzed.devzed.Repository.IAboutRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutService {

    @Autowired
    IAboutRepository aboutRepository;


    public List<About> list() {
        return aboutRepository.findAll();
    }

    public Optional<About> getOne(int id) {
        return aboutRepository.findById(id);
    }

    public Optional<About> getByTitle(String title) {
        return aboutRepository.findByTitle(title);
    }

    public void save(About about) {
        aboutRepository.save(about);
    }

    public void delete(int id) {
        aboutRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return aboutRepository.existsById(id);
    }

    public boolean existsByNombre(String title) {
        return aboutRepository.existsByTitle(title);
    }

}
