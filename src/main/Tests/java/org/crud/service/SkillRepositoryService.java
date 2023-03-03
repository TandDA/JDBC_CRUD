package org.crud.service;

import org.crud.model.Skill;
import org.crud.model.Specialty;
import org.crud.repository.Database.DatabaseSkillRepository;
import org.crud.repository.Database.DatabaseSpecialtyRepository;
import org.crud.repository.SkillRepository;
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
class SkillRepositoryService {

    SkillRepository skillRepository;
    RepositoryService repositoryService;
    @BeforeEach
    void setUp() {
        skillRepository = Mockito.mock(DatabaseSkillRepository.class);
        repositoryService = new RepositoryService(skillRepository);
    }

    @Test
    void getById_Not_Null() throws SQLException {
        Skill skill = new Skill();
        skill.setName("Eat food");
        skill.setId(1);
        Mockito.doReturn(skill).when(skillRepository).getById(1);

        assertEquals(repositoryService.getById(1),skill);
    }
    @Test
    void getById_Is_Null() throws SQLException {
        Mockito.doReturn(null).when(skillRepository).getById(Mockito.anyInt());

        assertEquals(repositoryService.getById(23),null);
    }
    @Test
    void getAll_Not_Null() throws SQLException {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill());
        skills.add(new Skill());
        Mockito.doReturn(skills).when(skillRepository).getAll();

        assertEquals(repositoryService.getAll(),skills);
    }
    @Test
    void getAll_Is_Null() throws SQLException {
        Mockito.doReturn(null).when(skillRepository).getAll();

        assertEquals(repositoryService.getAll(),null);
    }
    @Test
    void save_Not_Null() throws SQLException {
        Skill skill = new Skill();
        Mockito.doReturn(skill).when(skillRepository).save(skill);

        assertEquals(repositoryService.save(skill),skill);
    }
    @Test
    void save_Is_Null() throws SQLException {
        Skill skill = null;
        Mockito.doReturn(skill).when(skillRepository).save(skill);

        assertEquals(repositoryService.save(skill),null);
    }
    @Test
    void update_Not_Null() throws SQLException {
        Skill skill = new Skill();
        Mockito.doReturn(skill).when(skillRepository).update(skill);

        assertEquals(repositoryService.update(skill),skill);
    }
    @Test
    void update_Is_Null() throws SQLException {
        Skill skill = null;
        Mockito.doReturn(skill).when(skillRepository).update(skill);

        assertEquals(repositoryService.update(skill),null);
    }
}