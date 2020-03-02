package com.cursor.hw16.entity;

import java.util.Objects;

public class Profile {

    private int id;
    private String username;
    private String job_title;
    private String department;
    private String company;
    private String skill;

    public Profile(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id &&
                Objects.equals(username, profile.username) &&
                Objects.equals(job_title, profile.job_title) &&
                Objects.equals(department, profile.department) &&
                Objects.equals(company, profile.company) &&
                Objects.equals(skill, profile.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, job_title, department, company, skill);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", username='" + username.replaceAll("\\s+", " ")  + '\'' +
                ", job_title='" + job_title.replaceAll("\\s+", " ")  + '\'' +
                ", department='" + department.replaceAll("\\s+", " ")  + '\'' +
                ", company='" + company.replaceAll("\\s+", " ")  + '\'' +
                ", skill='" + skill.replaceAll("\\s+", " ")  + '\'' +
                '}';
    }
}