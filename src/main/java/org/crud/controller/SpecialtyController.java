package org.crud.controller;

import org.crud.model.Specialty;
import org.crud.repository.SpecialtyRepository;
import org.crud.repository.Database.DatabaseSpecialtyRepository;
import org.crud.service.SpecialtyService;

import java.util.List;

public class SpecialtyController {
    private SpecialtyRepository specialtyRepository = new DatabaseSpecialtyRepository();
    private SpecialtyService specialtyService = new SpecialtyService(specialtyRepository);
    public Specialty create(Specialty specialty){
        specialtyService.save(specialty);
        return specialty;
    }

    public Specialty read(Integer id){
        return specialtyService.getById(id);
    }
    public List<Specialty> readAll(){
        return specialtyService.getAll();
    }

    public void update(Specialty specialty){
        specialtyService.update(specialty);
    }

    public void delete(Integer id){
        specialtyService.deleteById(id);
    }
}
