package org.crud.repository.Database;

import org.crud.model.Developer;
import org.crud.model.Skill;
import org.crud.model.Specialty;
import org.crud.repository.DeveloperRepository;
import org.crud.repository.SkillRepository;
import org.crud.repository.SpecialtyRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDeveloperRepository implements DeveloperRepository {
    DatabaseContext dbContext = DatabaseContext.getDatabaseContext();
    SkillRepository skillRepository = new DatabaseSkillRepository();
    SpecialtyRepository specialtyRepository = new DatabaseSpecialtyRepository();
    @Override
    public Developer getById(Integer id) {
        String sql =
                "SELECT " +
                "developer.Id, developer.firstName, developer.lastName, developer.statusId AS developerStatusId, " +
                "specialty.Id AS specialtyId, specialty.name AS specialtyName, " +
                "skill.id AS skillId, skill.name AS skillName " +
                "FROM developer " +
                "JOIN devSkill ON developer.Id = devskill.devId " +
                "JOIN specialty ON developer.specialtyId = specialty.Id " +
                "JOIN skill ON devSkill.skillId = skill.Id WHERE developer.Id ="+id;
        ResultSet developerSet;
        String firstName;
        String lastName;
        int specialtyId;
        String specialtyName;
        int skillId;
        String skillName;
        int statusId;
        List<Skill> skills = new ArrayList<>();

        Specialty specialty;
        try {
            developerSet = dbContext.statement.executeQuery(sql);
            if(!developerSet.next())
                return null;
            firstName = developerSet.getString("firstName");
            lastName = developerSet.getString("lastName");

            specialtyId = developerSet.getInt("specialtyId");
            specialtyName = developerSet.getString("specialtyName");
            specialty = new Specialty(specialtyId,specialtyName);

            skillId = developerSet.getInt("skillId");
            skillName = developerSet.getString("skillName");
            skills.add(new Skill(skillId,skillName));

            while (developerSet.next()){
                skillId = developerSet.getInt("skillId");
                skillName = developerSet.getString("skillName");
                skills.add(new Skill(skillId,skillName));
            }

            return new Developer(id,firstName,lastName,skills,specialty);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Developer> getAll() {
        return null;
    }

    @Override
    public Developer save(Developer developer) {
        String sql = String.format("INSERT INTO developer(firstName,lastName,specialtyId) values(\"%s\",\"%s\",%s)",
                developer.getFirstName(),
                developer.getLastName(),
                developer.getSpecialty().getId()
        );
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        String sql = String.format("UPDATE developer SET firstName=\"%s\", lastName=\"%s\", specialtyId=%s WHERE id=%s",
                developer.getFirstName(),
                developer.getLastName(),
                developer.getSpecialty().getId(),
                developer.getId()
        );
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
        return developer;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "UPDATE developer SET statusId = 2 WHERE id=" + id;
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
    }
}
