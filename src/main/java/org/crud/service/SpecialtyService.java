package org.crud.service;

import org.crud.model.Specialty;
import org.crud.repository.SpecialtyRepository;

import java.util.List;

public class SpecialtyService implements SpecialtyRepository {
    SpecialtyRepository specialtyRepository;
    public SpecialtyService(SpecialtyRepository specialtyRepository){
        this.specialtyRepository = specialtyRepository;
    }
    @Override
    public Specialty getById(Integer id) {
        return specialtyRepository.getById(id);
    }

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.getAll();
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public Specialty update(Specialty specialty) {
        return specialtyRepository.update(specialty);
    }

    @Override
    public void deleteById(Integer id) {
        specialtyRepository.deleteById(id);
    }
}
