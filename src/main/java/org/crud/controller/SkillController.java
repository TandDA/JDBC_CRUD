package org.crud.controller;

import org.crud.model.Skill;
import org.crud.repository.Database.DatabaseSkillRepository;
import org.crud.repository.SkillRepository;
import org.crud.service.SkillService;

import java.util.List;

public class SkillController {
    private SkillRepository skillRepository = new DatabaseSkillRepository();
    private SkillService skillService = new SkillService(skillRepository);

    public Skill create(Skill skill){
        return skillService.save(skill);
    }
    public Skill read(Integer id){
        return skillService.getById(id);
    }

    public List<Skill> readAll(){
        return skillService.getAll();
    }

    public void update(Skill skill){
        skillService.update(skill);
    }

    public void delete(Integer id){
        skillService.deleteById(id);
    }

}
