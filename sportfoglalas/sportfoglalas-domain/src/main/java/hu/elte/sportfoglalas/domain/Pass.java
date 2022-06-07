package hu.elte.sportfoglalas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Pass {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Player player;

    private LocalDate purchaseDate;

    @ManyToOne
    private SportCategory sportCategory;

    private double discount; // 0.9 vagy 0.75

    private int remainingReservations; // 0 - 20



    public Pass() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseTime) {
        this.purchaseDate = purchaseTime;
    }

    public SportCategory getSportCategory() {
        return sportCategory;
    }

    public void setSportCategory(SportCategory sportCategory) {
        this.sportCategory = sportCategory;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getRemainingReservations() {
        return remainingReservations;
    }

    public void setRemainingReservations(int remainingReservations) {
        this.remainingReservations = remainingReservations;
    }
}

// Pass10 --> 10% discount
// Pass20 --> 25% discount
