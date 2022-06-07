package hu.elte.sportfoglalas.application.webdomain;

import hu.elte.sportfoglalas.domain.UserType;

public class RegistrationDTO {
    private String username;
    private String password;
    private UserType userType;
    private String name;


    public RegistrationDTO() {
    }


    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
