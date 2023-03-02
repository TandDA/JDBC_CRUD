package org.crud.repository.Database;

import org.crud.model.DevSkill;
import org.crud.repository.DevSkillRepository;

import java.sql.SQLException;
import java.util.List;

public class DatabaseDevSkillRepository implements DevSkillRepository {
    DatabaseContext dbContext = DatabaseContext.getDatabaseContext();
    @Override
    public DevSkill getById(DevSkill integer) {
        return null;
    }

    @Override
    public List<DevSkill> getAll() {
        return null;
    }

    @Override
    public DevSkill save(DevSkill devSkill) {
        String sql = String.format("INSERT INTO devSkill(devId,skillId) values(%s,%s)",
                devSkill.getDevId(),
                devSkill.getSkillId()
        );
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
        return null;
    }

    @Override
    public DevSkill update(DevSkill devSkill) {
        return null;
    }

    @Override
    public void deleteById(DevSkill devSkill) {
        String sql = String.format("UPDATE devSkill SET statusId = 2 WHERE devId=%s AND skillId=%s",
                devSkill.getDevId(),
                devSkill.getSkillId()
        );
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
    }
}
