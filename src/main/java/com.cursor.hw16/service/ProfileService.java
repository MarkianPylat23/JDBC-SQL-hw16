package com.cursor.hw16.service;

import com.cursor.hw16.bl.Util;
import com.cursor.hw16.entity.Profile;
import com.cursor.hw16.model.ProfileModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileService extends Util implements ProfileModel {

    Connection connection = getConnection();

    @Override
    public void addProfiles(Profile profile) {

        String sql = "INSERT INTO profiles (id, username, job_title, department, company, skill) VALUES (?, ?, ?, ?, ?, ?) ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, profile.getId());
                preparedStatement.setString(2, profile.getUsername());
                preparedStatement.setString(3, profile.getJob_title());
                preparedStatement.setString(4, profile.getDepartment());
                preparedStatement.setString(5, profile.getCompany());
                preparedStatement.setString(6, profile.getSkill());

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public List<Profile> getAllProfiles() {

        List<Profile> profilesList = new ArrayList<>();

        String sql = "SELECT * FROM profiles";

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Profile profile = new Profile();

                profile.setId(resultSet.getInt("id"));
                profile.setUsername(resultSet.getString("username"));
                profile.setJob_title(resultSet.getString("job_title"));
                profile.setDepartment(resultSet.getString("department"));
                profile.setCompany(resultSet.getString("company"));
                profile.setSkill(resultSet.getString("skill"));

                profilesList.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Profile getProfileById(int id) {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM accounts WHERE id=?";

        Profile profiles = new Profile();

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                profiles.setId(resultSet.getInt("id"));
                profiles.setUsername(resultSet.getString("username"));
                profiles.setJob_title(resultSet.getString("job_title"));
                profiles.setDepartment(resultSet.getString("department"));
                profiles.setCompany(resultSet.getString("company"));
                profiles.setSkill(resultSet.getString("skill"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public void updateProfiles(Profile profile) {

        Profile profiles = new Profile();

        String sql = "UPDATE profiles SET username=?, job_title=?, department=?, company=?, skill=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, profile.getUsername());
            preparedStatement.setString(2, profile.getJob_title());
            preparedStatement.setString(3, profile.getDepartment());
            preparedStatement.setString(4, profile.getCompany());
            preparedStatement.setString(5, profile.getSkill());
            preparedStatement.setInt(6, profile.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeProfiles(int id) {

        String sql = "DELETE FROM profiles WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
