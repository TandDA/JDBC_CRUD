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
        String sql = "SELECT * FROM developer";
        List<Developer> developerList = new ArrayList<>();
        ResultSet resultSet;
        try {
            resultSet = dbContext.statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int specialtyId = resultSet.getInt("specialtyId");

                developerList.add(new Developer(id,firstName,lastName, null, null));
            }
            for (Developer dev: developerList) {
                List<Skill> skills = skillRepository.getAll().stream().filter(s -> s.getId() == dev.getId()).toList();
                dev.setSkills(skills);

            }
            return developerList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Developer save(Developer developer) {
        String sql1 = String.format("INSERT INTO developer(firstName,lastName,specialtyId) values(\"%s\",\"%s\",%s)",
                developer.getFirstName(),
                developer.getLastName(),
                developer.getSpecialty().getId()
        );
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql1);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");

        for (Skill skill:developer.getSkills()) {
            String sql2 = String.format("INSERT INTO devSkill(devId,skillId) values(%s,%s)",
                    developer.getId(),
                    skill.getId()
            );
            try {
                dbContext.statement.executeUpdate(sql2);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
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
