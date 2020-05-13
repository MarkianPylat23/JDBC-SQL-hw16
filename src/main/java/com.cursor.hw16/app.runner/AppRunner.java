package com.cursor.hw16.app.runner;

import com.cursor.hw16.entity.Accounts;
import com.cursor.hw16.entity.Profile;
import com.cursor.hw16.service.AccountsService;
import com.cursor.hw16.service.ProfileService;

import java.sql.SQLException;
import java.util.List;

public class AppRunner {

    private AccountsService accountsService = new AccountsService();
    private ProfileService profilesService = new ProfileService();
    private Accounts accounts = new Accounts();
    private Profile profiles = new Profile();

    public void runApp() {

        try {
            showAllAccounts();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addAccountToTable(int id, String firstName, String lastName, String city, String gender, String username) {

        accounts.setId(id);
        accounts.setFirst_name(firstName);
        accounts.setLast_name(lastName);
        accounts.setCity(city);
        accounts.setGender(gender);
        accounts.setUsername(username);

        accountsService.addAccounts(accounts);
    }

    private void showAllAccounts() throws SQLException {

        List<Accounts> modelList = accountsService.getAllAccounts();

        for (Accounts model : modelList) {
            System.out.println(model);
        }
    }

    private void findAccountById(int id) throws SQLException {
        System.out.println(accountsService.getAccountById(id));
    }

    private void updateAccount(int id, String firstName, String lastName, String city, String gender, String username) {
        Accounts accounts = new Accounts();

        accounts.setId(id);
        accounts.setFirst_name(firstName);
        accounts.setLast_name(lastName);
        accounts.setCity(city);
        accounts.setGender(gender);
        accounts.setUsername(username);

        accountsService.updateAccounts(accounts);
    }

    private void deleteAccountById(int id) {
        accountsService.removeAccounts(id);
    }

    private void addProfileToTable(int id, String username, String job_title, String department, String company, String skill) {

        profiles.setId(id);
        profiles.setUsername(username);
        profiles.setJob_title(job_title);
        profiles.setDepartment(department);
        profiles.setCompany(company);
        profiles.setSkill(skill);

        profilesService.addProfiles(profiles);
    }

    private void showAllProfiles() throws SQLException{

        List<Profile> profilesList = profilesService.getAllProfiles();

        for (Profile model : profilesList) {
            System.out.println(model);
        }
    }

    private void findProfileById(int id) throws SQLException {
        System.out.println(profilesService.getProfileById(id));
    }

    private void updateProfile(int id, String username, String jobTitle, String department, String company, String skill) {
        Accounts account = new Accounts();

        profiles.setId(id);
        profiles.setUsername(username);
        profiles.setJob_title(jobTitle);
        profiles.setDepartment(department);
        profiles.setCompany(company);
        profiles.setSkill(skill);

        profilesService.updateProfiles(profiles);
    }

    private void deleteProfileById(int id) {
        profilesService.removeProfiles(id);
    }
}