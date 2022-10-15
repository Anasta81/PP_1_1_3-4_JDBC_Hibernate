package jm.task.core.jdbc.util;

import java.sql.*;

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

    public PreparedStatement prepareStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return preparedStatement;
    }
}

