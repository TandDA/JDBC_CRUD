package org.crud.controller;

import org.crud.model.Developer;
import org.crud.repository.DeveloperRepository;
import org.crud.repository.Database.DatabaseDeveloperRepository;
import org.crud.service.DeveloperService;

import java.util.List;

public class DeveloperController{
    private DeveloperRepository developerRepository = new DatabaseDeveloperRepository();
    private DeveloperService developerService = new DeveloperService(developerRepository);

    public Developer create(Developer developer) {
        developerService.save(developer);
        return developer;
    }

    public Developer read(Integer id) {
        return developerService.getById(id);
    }

    public List<Developer> readAll() {
        return developerService.getAll();
    }

    public void update(Developer developer){
        developerService.update(developer);
    }

    public void delete(Integer id) {
        developerService.deleteById(id);
    }
}
