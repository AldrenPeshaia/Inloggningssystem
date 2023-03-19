package org.example;

public class Users {


    public String fullName;
    public String userName;
    public String password;


    public Users() {
    }

    public Users(String fullName, String userName, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Full name: " + fullName + "\nUsername" + userName + "\nPassword" + password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
