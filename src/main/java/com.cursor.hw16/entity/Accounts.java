package com.cursor.hw16.entity;

import java.util.Objects;

public class Accounts {

    private int id;
    private String first_name;
    private String last_name;
    private String city;
    private String gender;
    private String username;

    public Accounts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return id == accounts.id &&
                Objects.equals(first_name, accounts.first_name) &&
                Objects.equals(last_name, accounts.last_name) &&
                Objects.equals(city, accounts.city) &&
                Objects.equals(gender, accounts.gender) &&
                Objects.equals(username, accounts.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, city, gender, username);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
