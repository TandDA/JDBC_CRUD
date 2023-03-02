package org.crud.repository.Database;

import org.crud.model.Skill;
import org.crud.repository.SkillRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseSkillRepository implements SkillRepository {
    DatabaseContext dbContext = DatabaseContext.getDatabaseContext();
    @Override
    public Skill getById(Integer id) {
        String sql = "SELECT * FROM skill WHERE id="+id;
        ResultSet specialtySet;
        String name;
        Skill specialty;
        try {
            specialtySet = dbContext.statement.executeQuery(sql);
            name = specialtySet.getString("name");
            specialty = new Skill(id,name);
            return specialty;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Skill> getAll() {
        return null;
    }

    @Override
    public Skill save(Skill skill) {
        String sql = "INSERT INTO skill(name) values(\"" + skill.getName() + "\")";
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        String sql = "UPDATE skill SET name = \"" + skill.getName() + "\" WHERE id="+ skill.getId();
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
        return skill;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "UPDATE skill SET statusId = 2 WHERE id=" + id;
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
    }
}
