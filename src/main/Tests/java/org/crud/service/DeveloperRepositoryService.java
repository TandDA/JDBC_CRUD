package org.crud.service;

import org.crud.model.Developer;
import org.crud.repository.DatabaseHibernate.HibernateDeveloperRepository;
import org.crud.repository.DeveloperRepository;
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
class DeveloperRepositoryService {

    DeveloperRepository developerRepository;
    DeveloperService developerService;
    @BeforeEach
    void setUp() {
        developerRepository = Mockito.mock(HibernateDeveloperRepository.class);
        developerService = new DeveloperService(developerRepository);
    }

    @Test
    void getById_Not_Null() throws SQLException {
        Developer developer = new Developer();
        developer.setFirstName("Dima");
        developer.setLastName("T");
        developer.setId(1);
        Mockito.doReturn(developer).when(developerRepository).getById(1);

        assertEquals(developerService.getById(1),developer);
    }
    @Test
    void getById_Is_Null() throws SQLException {
        Mockito.doReturn(null).when(developerRepository).getById(Mockito.anyInt());

        assertEquals(developerService.getById(23),null);
    }
    @Test
    void getAll_Not_Null() throws SQLException {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer());
        developers.add(new Developer());
        Mockito.doReturn(developers).when(developerRepository).getAll();

        assertEquals(developerService.getAll(),developers);
    }
    @Test
    void getAll_Is_Null() throws SQLException {
        Mockito.doReturn(null).when(developerRepository).getAll();

        assertEquals(developerService.getAll(),null);
    }
    @Test
    void save_Not_Null() throws SQLException {
        Developer developer = new Developer();
        Mockito.doReturn(developer).when(developerRepository).save(developer);

        assertEquals(developerService.save(developer),developer);
    }
    @Test
    void save_Is_Null() throws SQLException {
        Developer developer = null;
        Mockito.doReturn(developer).when(developerRepository).save(developer);

        assertEquals(developerService.save(developer),null);
    }
    @Test
    void update_Not_Null() throws SQLException {
        Developer developer = new Developer();
        Mockito.doReturn(developer).when(developerRepository).update(developer);

        assertEquals(developerService.update(developer),developer);
    }
    @Test
    void update_Is_Null() throws SQLException {
        Developer developer = null;
        Mockito.doReturn(developer).when(developerRepository).update(developer);

        assertEquals(developerService.update(developer),null);
    }
}