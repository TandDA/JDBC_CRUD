package org.crud;

import org.crud.repository.Database.DatabaseContext;
import org.crud.view.AppView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppRunner {
    private  static void InitDB() throws SQLException {
        DatabaseContext databaseContext = DatabaseContext.getDatabaseContext();
        ResultSet resultSet;
        resultSet = databaseContext.statement.executeQuery("SELECT * FROM taskDB.status;");

        int col = 0;
        while(resultSet.next()){
            col++;
        }
        if(col == 0){
            databaseContext.statement.executeUpdate("INSERT INTO status(name) value(\"ACTIVE\"),(\"DELETED\");");
        }
    }

    public static void main(String[] args) {
        try {
            InitDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        AppView appView = new AppView();
        appView.runApp();
    }
}
