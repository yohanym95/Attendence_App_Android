package com.example.yohan.attendencesystem;

public class User {

    private String name;
    private String Password;
    private String Email;
    private String year;
    private String course;

    public User(){

    }

    public User(String name, String email, String password, String year, String course) {
        this.name = name;
        Email = email;
        Password = password;
        this.year = year;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getYear() {
        return year;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
