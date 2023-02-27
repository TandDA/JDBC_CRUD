package org.crud.controller;

import org.crud.model.Specialty;
import org.crud.repository.SpecialtyRepository;
import org.crud.repository.Database.DatabaseSpecialtyRepository;

import java.util.List;

public class SpecialtyController {
    private SpecialtyRepository specialtyRepository = new DatabaseSpecialtyRepository();

    public Specialty create(Specialty specialty){
        specialtyRepository.save(specialty);
        return specialty;
    }

    public Specialty read(Integer id){
        return specialtyRepository.getById(id);
    }
    public List<Specialty> readAll(){
        return specialtyRepository.getAll();
    }

    public void update(Specialty specialty){
        specialtyRepository.update(specialty);
    }

    public void delete(Integer id){
        specialtyRepository.deleteById(id);
    }
}
