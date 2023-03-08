package org.crud.service;

import org.crud.model.Developer;
import org.crud.repository.DeveloperRepository;

import java.util.List;

public class DeveloperService implements DeveloperRepository {
    DeveloperRepository developerRepository;
    public DeveloperService(DeveloperRepository developerRepository){
        this.developerRepository = developerRepository;
    }

    @Override
    public Developer getById(Integer id) {
        return developerRepository.getById(id);
    }

    @Override
    public List<Developer> getAll() {
        return developerRepository.getAll();
    }

    @Override
    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public Developer update(Developer developer) {
        return developerRepository.update(developer);
    }

    @Override
    public void deleteById(Integer id) {
        developerRepository.deleteById(id);
    }
}
