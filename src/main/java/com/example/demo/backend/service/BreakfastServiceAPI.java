package com.example.demo.backend.service;

import com.example.demo.backend.entity.Breakfast;
import com.example.demo.backend.repository.BreakfastRepository;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api")
public class BreakfastServiceAPI  {

    @Autowired
    BreakfastRepository repository;

    @GetMapping("/rest")
    public Collection<Breakfast> findAll() {
        return repository.findAll();
    }

    @PostMapping("/rest")
    public Breakfast add(Breakfast breakfast) {
        Collection<Breakfast> list = repository.findAll();
        boolean test = false;

        for (Breakfast t : list){
            test = Objects.equals(t.getBreakfastItem(), breakfast.getBreakfastItem()) || Objects.equals(t.getCpf(),breakfast.getCpf());
        }

        if(!test && breakfast.getCpf().length()==11){
            return repository.save(breakfast);
        }
        
        else return repository.save(null);
    }

    @PutMapping("/rest")
    public Breakfast update(Breakfast breakfast) {
        return repository.save(breakfast);
    }

    @DeleteMapping("/rest")
    public void delete(Breakfast breakfast) {
        repository.delete(breakfast);
    }
}
