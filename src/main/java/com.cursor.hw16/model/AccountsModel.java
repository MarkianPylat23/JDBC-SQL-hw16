package com.cursor.hw16.model;

import com.cursor.hw16.entity.Accounts;

import java.sql.SQLException;
import java.util.List;

public interface AccountsModel {

    void addAccounts(Accounts accounts);

    List<Accounts> getAllAccounts() throws SQLException;

    Accounts getAccountById(int id) throws SQLException;

    void updateAccounts(Accounts accounts) throws SQLException;

    void removeAccounts(int id) throws SQLException;


}