package com.cursor.hw16.model;


import com.cursor.hw16.entity.Profile;

import java.sql.SQLException;
import java.util.List;

public interface ProfileModel {

    void addProfiles(Profile profile) throws SQLException;

    List<Profile> getAllProfiles() throws SQLException;

    Profile getProfileById(int id)throws SQLException;

    void updateProfiles(Profile profile) throws SQLException;

    void removeProfiles(int id) throws SQLException;
}