package org.crud.repository.Database;

import org.crud.model.Specialty;
import org.crud.repository.SpecialtyRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSpecialtyRepository implements SpecialtyRepository {
    DatabaseContext dbContext = DatabaseContext.getDatabaseContext();
    @Override
    public Specialty getById(Integer id) {
        String sql = "SELECT * FROM specialty WHERE id="+id;
        ResultSet specialtySet;
        String name;
        Specialty specialty;
        try {
            specialtySet = dbContext.statement.executeQuery(sql);
            if(!specialtySet.next())
                return null;
            name = specialtySet.getString("name");
            specialty = new Specialty(id,name);
            return specialty;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Specialty> getAll()  {
        String sql = "SELECT * FROM specialty";
        List<Specialty> specialtyList = new ArrayList<>();
        try {
            ResultSet resultSet = dbContext.statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                specialtyList.add(new Specialty(id,name));
            }
            return specialtyList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
