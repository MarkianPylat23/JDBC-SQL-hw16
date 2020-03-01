package com.cursor.hw16.service;

import com.cursor.hw16.bl.Util;
import com.cursor.hw16.entity.Accounts;
import com.cursor.hw16.model.AccountsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsService extends Util implements AccountsModel {

    Connection connection = getConnection();

    @Override
    public void addAccounts(Accounts accounts) {

        String sql = "INSERT INTO ACCOUNTS (id, first_name, last_name, city, gender, username) VALUES (?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, accounts.getId());
            preparedStatement.setString(2, accounts.getFirst_name());
            preparedStatement.setString(3, accounts.getLast_name());
            preparedStatement.setString(4, accounts.getCity());
            preparedStatement.setString(5, accounts.getGender());
            preparedStatement.setString(6, accounts.getUsername());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        List<Accounts> accountsList = new ArrayList<>();

        String sql = "SELECT * FROM accounts";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Accounts allAccounts = new Accounts();
                allAccounts.setId(resultSet.getInt("id"));
                allAccounts.setFirst_name("first_name");
                allAccounts.setLast_name("last_name");
                allAccounts.setCity(resultSet.getString("city"));
                allAccounts.setGender(resultSet.getString("gender"));
                allAccounts.setUsername(resultSet.getString("username"));

                accountsList.add(allAccounts);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return accountsList;
    }

    @Override
    public Accounts getAccountById(int id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM accounts WHERE id=?";

        Accounts accountsById = new Accounts();

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                accountsById.setId(resultSet.getInt("id"));
                accountsById.setFirst_name(resultSet.getString("first_name"));
                accountsById.setLast_name(resultSet.getString("last_name"));
                accountsById.setCity(resultSet.getString("city"));
                accountsById.setGender(resultSet.getString("gender"));
                accountsById.setUsername(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return accountsById;
    }

    @Override
    public void updateAccounts(Accounts accounts) {

        Accounts updateAccounts = new Accounts();

        String sql = "UPDATE accounts SET first_name=?, last_name=?, city=?, gender=?, username=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(6, updateAccounts.getId());
            preparedStatement.setString(1, updateAccounts.getFirst_name());
            preparedStatement.setString(2, updateAccounts.getLast_name());
            preparedStatement.setString(3, updateAccounts.getCity());
            preparedStatement.setString(4, updateAccounts.getGender());
            preparedStatement.setString(5, updateAccounts.getUsername());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAccounts(int id) {

        String sql = "DELETE FROM accounts WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
