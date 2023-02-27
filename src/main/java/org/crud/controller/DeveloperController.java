package org.crud.controller;

import org.crud.model.Developer;
import org.crud.repository.DeveloperRepository;
import org.crud.repository.Database.DatabaseDeveloperRepository;

import java.util.List;

public class DeveloperController{
    private DeveloperRepository developerRepository = new DatabaseDeveloperRepository();

    public Developer create(Developer developer) {
        developerRepository.save(developer);
        return developer;
    }

    public Developer read(Integer id) {
        return developerRepository.getById(id);
    }

    public List<Developer> readAll() {
        return developerRepository.getAll();
    }

    public void update(Developer developer){
        developerRepository.update(developer);
    }

    public void delete(Integer id) {
        developerRepository.deleteById(id);
    }
}
