package org.crud.service;

import org.crud.model.Specialty;
import org.crud.repository.DatabaseJDBC.DatabaseSpecialtyRepository;
import org.crud.repository.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpecialtyRepositoryServiceTest {

    SpecialtyRepository specialtyRepository;
    RepositoryService repositoryService;
    @BeforeEach
    void setUp() {
        specialtyRepository = Mockito.mock(DatabaseSpecialtyRepository.class);
        repositoryService = new RepositoryService(specialtyRepository);
    }

    @Test
    void getById_Not_Null() throws SQLException {
        Specialty specialty = new Specialty();
        specialty.setName("Java developer");
        specialty.setId(1);
        Mockito.doReturn(specialty).when(specialtyRepository).getById(Mockito.anyInt());

        assertEquals(repositoryService.getById(23),specialty);
    }
    @Test
    void getById_Is_Null() throws SQLException {
        Mockito.doReturn(null).when(specialtyRepository).getById(Mockito.anyInt());

        assertEquals(repositoryService.getById(23),null);
    }
    @Test
    void getAll_Not_Null() throws SQLException {
        List<Specialty> specialties = new ArrayList<>();
        specialties.add(new Specialty());
        specialties.add(new Specialty());
        Mockito.doReturn(specialties).when(specialtyRepository).getAll();

        assertEquals(repositoryService.getAll(),specialties);
    }
    @Test
    void getAll_Is_Null() throws SQLException {
        Mockito.doReturn(null).when(specialtyRepository).getAll();

        assertEquals(repositoryService.getAll(),null);
    }
    @Test
    void save_Not_Null() throws SQLException {
        Specialty specialty = new Specialty();
        Mockito.doReturn(specialty).when(specialtyRepository).save(specialty);

        assertEquals(repositoryService.save(specialty),specialty);
    }
    @Test
    void save_Is_Null() throws SQLException {
        Specialty specialty = null;
        Mockito.doReturn(specialty).when(specialtyRepository).save(specialty);

        assertEquals(repositoryService.save(specialty),null);
    }
    @Test
    void update_Not_Null() throws SQLException {
        Specialty specialty = new Specialty();
        Mockito.doReturn(specialty).when(specialtyRepository).update(specialty);

        assertEquals(repositoryService.update(specialty),specialty);
    }
    @Test
    void update_Is_Null() throws SQLException {
        Specialty specialty = null;
        Mockito.doReturn(specialty).when(specialtyRepository).update(specialty);

        assertEquals(repositoryService.update(specialty),null);
    }
}