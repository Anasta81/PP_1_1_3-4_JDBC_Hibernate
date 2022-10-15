package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Util util = new Util();
        Statement stat = util.getStatement();
        String query = "create table IF NOT EXISTS Users (id bigint primary key auto_increment, " +
                "name varchar(255), lastName varchar(255), age int)";
        try {
            stat.execute(query);
            stat.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        Util util = new Util();
        Statement stat = util.getStatement();
        String query = "drop table IF EXISTS Users";
        try {
            stat.execute(query);
            stat.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util util = new Util();
        String query = "insert into users (name, lastName, age) values (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = util.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            preparedStatement.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        Util util = new Util();
        String query = "delete from Users where id = ?";
        try {
            PreparedStatement preparedStatement = util.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        Util util = new Util();
        List<User> usersList = new ArrayList<>();
        String query = "select * from Users";
        try {
            PreparedStatement preparedStatement = util.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    User user = new User(rs.getString("name"),
                            rs.getString("lastName"), rs.getByte("age"));
                    usersList.add(user);
                }

            preparedStatement.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }

    public void cleanUsersTable() {
        Util util = new Util();
        String query = "truncate table Users";
        try {
            PreparedStatement preparedStatement = util.prepareStatement(query);
            preparedStatement.executeUpdate();
            preparedStatement.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
