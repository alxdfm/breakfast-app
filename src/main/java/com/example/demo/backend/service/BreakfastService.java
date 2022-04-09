package com.example.demo.backend.service;

import com.example.demo.backend.entity.Breakfast;
import com.example.demo.backend.repository.BreakfastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BreakfastService implements CrudListener<Breakfast> {

    private final BreakfastRepository repository;

    @Override
    public Collection<Breakfast> findAll() {
        return repository.findAll();
    }

    @Override
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

    @Override
    public Breakfast update(Breakfast breakfast) {
        return repository.save(breakfast);
    }

    @Override
    public void delete(Breakfast breakfast) {
        repository.delete(breakfast);
    }
}
