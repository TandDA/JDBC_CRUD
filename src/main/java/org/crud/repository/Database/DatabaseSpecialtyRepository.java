package org.crud.repository.Database;

import org.crud.model.Specialty;
import org.crud.repository.SpecialtyRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseSpecialtyRepository implements SpecialtyRepository {
    DatabaseContext dbContext = new DatabaseContext();
    @Override
    public Specialty getById(Integer id) {
        String sql = "SELECT * FROM specialty WHERE id="+id;
        ResultSet specialtySet;
        String name;
        Specialty specialty;
        try {
            specialtySet = dbContext.statement.executeQuery(sql);
            specialtySet.next();
            name = specialtySet.getString("name");
            specialty = new Specialty(id,name);
            return specialty;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Specialty> getAll() {
        return null;
    }

    @Override
    public Specialty save(Specialty specialty) {
        String sql = "INSERT INTO specialty(name) values(\"" + specialty.getName() + "\")";
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
        return specialty;
    }

    @Override
    public Specialty update(Specialty specialty) {
        String sql = "UPDATE specialty SET name = \"" + specialty.getName() + "\" WHERE id="+ specialty.getId();
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
        return specialty;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "UPDATE specialty SET statusId = 2 WHERE id=" + id;
        int updateNumber = 0;
        try {
            updateNumber = dbContext.statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Произошла ошибка");
        }
        System.out.println("Успешно. Произошло " + updateNumber + " изменение");
    }
}
