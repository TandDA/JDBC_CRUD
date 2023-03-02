package org.crud.repository.Database;

import java.sql.*;

public class DatabaseContext {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/taskDB?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
    private static final String USER = "root";
    private static final String PASSWORD = "password711";

    private static DatabaseContext databaseContext;
    public Statement statement;

    public static synchronized  DatabaseContext getDatabaseContext(){
        if(databaseContext == null){
            databaseContext = new DatabaseContext();
        }
        return databaseContext;
    }

    private DatabaseContext(){
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
