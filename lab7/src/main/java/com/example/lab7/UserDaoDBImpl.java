package com.example.lab7;

import java.sql.*;

public class UserDaoDBImpl implements UserDAO {


    @Override
    public boolean isRegistered(String login, String password) {
        try (Connection connection = ServiceDb.getConnection();
             PreparedStatement statement = connection.prepareStatement("select count(*) as 'count' from usrs where email = ? and password = ?");) {
            statement.setString(1, login);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                final int count = resultSet.getInt("count");
                return count == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addUser(String login, String password) {
        try (Connection connection = ServiceDb.getConnection();
             PreparedStatement statement = connection.prepareStatement("insert into usrs (password, email) values (?, ?)")) {
            statement.setString(1, login);
            statement.setString(2, password);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
