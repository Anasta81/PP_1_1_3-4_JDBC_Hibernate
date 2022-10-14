package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl bnb = new UserServiceImpl();
        bnb.createUsersTable();
        bnb.saveUser("Harry", "Potter", (byte) 42);
        bnb.saveUser("Ron", "Weasley", (byte) 42);
        bnb.saveUser("Hermione", "Granger", (byte) 43);
        bnb.saveUser("Draco", "Malfoy", (byte) 42);
        bnb.getAllUsers().forEach(System.out::println);
        bnb.cleanUsersTable();
        bnb.dropUsersTable();
    }

}
