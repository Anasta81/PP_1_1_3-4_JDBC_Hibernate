package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    public Connection getConnection () {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test","root","Rg81ot81");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public Statement getStatement() {
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }
}

