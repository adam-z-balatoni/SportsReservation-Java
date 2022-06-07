package hu.elte.sportfoglalas.application.webdomain;

import java.time.LocalDate;

public class PlayerReservationDTO {
    private LocalDate purchaseDate;
    private String sportName;
    private int classPrice;
    private int coachPrice;
    private String purchasedWithPass;
    private int discount;
    private int finalPrice;



    public PlayerReservationDTO() {
    }



    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public int getClassPrice() {
        return classPrice;
    }

    public void setClassPrice(int classPrice) {
        this.classPrice = classPrice;
    }

    public int getCoachPrice() {
        return coachPrice;
    }

    public void setCoachPrice(int coachPrice) {
        this.coachPrice = coachPrice;
    }

    public String getPurchasedWithPass() {
        return purchasedWithPass;
    }

    public void setPurchasedWithPass(String purchasedWithPass) {
        this.purchasedWithPass = purchasedWithPass;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }


    @Override
    public String toString() {
        return "PlayerReservationDTO{" +
                "purchaseDate=" + purchaseDate +
                ", sportName='" + sportName + '\'' +
                ", classPrice=" + classPrice +
                ", coachPrice=" + coachPrice +
                ", purchasedWithPass='" + purchasedWithPass + '\'' +
                ", discount=" + discount +
                ", finalPrice=" + finalPrice +
                '}';
    }
}