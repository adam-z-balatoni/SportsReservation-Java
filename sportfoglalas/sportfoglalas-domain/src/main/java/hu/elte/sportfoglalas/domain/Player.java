package hu.elte.sportfoglalas.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Player extends User{

    private String name;



    public Player() {

    }

    public Player(String username, String password, UserType userType) {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
