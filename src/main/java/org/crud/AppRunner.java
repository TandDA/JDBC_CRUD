package org.crud;

import org.crud.repository.DatabaseJDBC.DatabaseContext;
import org.crud.view.AppView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppRunner {
    public static void main(String[] args) {

        AppView appView = new AppView();
        appView.runApp();
    }
}
