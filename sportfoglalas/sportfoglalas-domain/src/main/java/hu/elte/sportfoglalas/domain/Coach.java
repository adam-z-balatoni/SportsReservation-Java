package hu.elte.sportfoglalas.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Coach extends User {

    private String name;
    private double price;


    private boolean isAvailable;



    public Coach() {

    }

    public Coach(String username, String password, UserType userType) {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
