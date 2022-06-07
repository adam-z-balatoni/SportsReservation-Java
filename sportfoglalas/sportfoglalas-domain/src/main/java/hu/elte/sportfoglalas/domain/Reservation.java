package hu.elte.sportfoglalas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Player player;

    private LocalDate purchaseDate;

    @ManyToOne
    private Court court;

    @ManyToOne
    private Coach coach;

    private String startTime;

    @ManyToOne
    private Pass pass;



    public Reservation() {
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

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }



    public String toStringRaw() {
        return "Reservation{" +
                "id=" + id +
                ", player=" + player +
                ", court=" + court +
                ", coach=" + coach +
                ", startTime=" + startTime +
                ", pass=" + pass +
                '}';
    }

    @Override
    public String toString() {
        var coachData = (coach == null) ? coach : coach.getName();
        var passData = (pass == null) ? pass : pass.getSportCategory().getName() + " " + pass.getDiscount();

        return "Reservation{" +
                "id=" + id +
                ", player=" + player.getName() +
                ", court=" + court.getName() +
                ", coach=" + coachData +
                ", startTime=" + startTime +
                ", pass=" + passData +
                '}';
    }
}