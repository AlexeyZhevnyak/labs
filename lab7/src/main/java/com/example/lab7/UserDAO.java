package com.example.lab7;

public interface UserDAO {
    boolean isRegistered(String login, String password);

    void addUser(String login, String password);
}
