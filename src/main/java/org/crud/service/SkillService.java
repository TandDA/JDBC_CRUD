package org.crud.service;

import org.crud.model.Skill;
import org.crud.repository.SkillRepository;

import java.util.List;

public class SkillService implements SkillRepository {
    SkillRepository skillRepository;
    public SkillService(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }
    @Override
    public Skill getById(Integer id) {
        return skillRepository.getById(id);
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill update(Skill skill) {
        return skillRepository.update(skill);
    }

    @Override
    public void deleteById(Integer id) {
        skillRepository.deleteById(id);
    }
}
