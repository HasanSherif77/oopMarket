package com.example.hasphase1ui.files;

public abstract class User {
    protected String username;
    protected String password;
    protected Date dateOfBirth;


    public User(String username, String password, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public abstract boolean login(String username, String password);


    public void logout() {
        // logout functionallity
        System.out.println(username + " has logged out.");
    }
}
