package org.crud.controller;

import org.crud.model.DevSkill;
import org.crud.repository.Database.DatabaseDevSkillRepository;
import org.crud.repository.DevSkillRepository;

public class DevSkillController {
    DevSkillRepository devSkillRepository = new DatabaseDevSkillRepository();

    public void create(DevSkill devSkill) {
        devSkillRepository.save(devSkill);
    }
    public void delete(DevSkill devSkill) {
        devSkillRepository.deleteById(devSkill);
    }
}
