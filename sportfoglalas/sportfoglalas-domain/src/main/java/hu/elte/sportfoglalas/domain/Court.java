package hu.elte.sportfoglalas.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Court {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    private SportCategory sportCategory;

   // private final int capacity = 4;

    public Court() {
    }

    public Court(int id, String name, SportCategory sportCategory) {
        this.id = id;
        this.name = name;
        this.sportCategory = sportCategory;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SportCategory getSportCategory() {
        return sportCategory;
    }

    public void setSportCategory(SportCategory sportCategory) {
        this.sportCategory = sportCategory;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Court court = (Court) o;
        return id == court.id && Objects.equals(name, court.name) && Objects.equals(sportCategory, court.sportCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sportCategory);
    }
}
