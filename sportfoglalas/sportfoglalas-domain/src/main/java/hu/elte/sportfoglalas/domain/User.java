package hu.elte.sportfoglalas.domain;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class User {  //abstract

    @Id
    @GeneratedValue
    private int id;

    public String username;

    public String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private UserTypeAdmin userTypeAdmin;

    public User() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserTypeAdmin getUserTypeAdmin() {
        return userTypeAdmin;
    }

    public void setUserTypeAdmin(UserTypeAdmin userTypeAdmin) {
        this.userTypeAdmin = userTypeAdmin;
    }
}



