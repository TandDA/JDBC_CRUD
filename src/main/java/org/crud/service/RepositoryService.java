package org.crud.service;

import org.crud.repository.GenericRepository;

import java.util.List;

public class RepositoryService implements GenericRepository {
    GenericRepository genericRepository;
    public RepositoryService(GenericRepository genericRepository){
        this.genericRepository = genericRepository;
    }
    @Override
    public Object getById(Object id) {
        return genericRepository.getById(id);
    }

    @Override
    public List getAll() {
        return genericRepository.getAll();
    }

    @Override
    public Object save(Object entity) {
        return genericRepository.save(entity);
    }

    @Override
    public Object update(Object entity) {
        return genericRepository.update(entity);
    }

    @Override
    public void deleteById(Object entity) {
        genericRepository.deleteById(entity);
    }
}
