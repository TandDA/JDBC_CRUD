package org.crud.repository.Database;

import org.crud.model.Developer;
import org.crud.repository.DeveloperRepository;

import java.sql.SQLException;
import java.util.List;

public class DatabaseDeveloperRepository implements DeveloperRepository {
    DatabaseContext dbContext = DatabaseContext.getDatabaseContext();
    @Override
    public Developer getById(Integer id) {
        return null;
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
