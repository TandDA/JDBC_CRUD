package org.crud.controller;

import org.crud.model.DevSkill;
import org.crud.model.Skill;
import org.crud.repository.Database.DatabaseContext;
import org.crud.repository.Database.DatabaseDevSkillRepository;
import org.crud.repository.Database.DatabaseSkillRepository;
import org.crud.repository.DevSkillRepository;
import org.crud.repository.SkillRepository;
import org.crud.repository.Database.DatabaseSpecialtyRepository;

import java.sql.SQLException;
import java.util.List;

public class SkillController {
    private SkillRepository skillRepository = new DatabaseSkillRepository();
    private DevSkillRepository devSkillRepository = new DatabaseDevSkillRepository();

    public Skill create(Skill skill){
        skillRepository.save(skill);
        return skill;
    }
    public Skill read(Integer id){
        return skillRepository.getById(id);
    }

    public List<Skill> readAll(){
        return skillRepository.getAll();
    }

    public void update(Skill skill){
        skillRepository.update(skill);
    }

    public void delete(Integer id){
        skillRepository.deleteById(id);
    }

    public void linkSkill(DevSkill devSkill) {

        devSkillRepository.save(devSkill);
    }
}
