package hu.elte.sportfoglalas.application.webdomain;

import java.time.LocalDate;

public class PlayerPassDTO {
    private LocalDate purchaseDate;
    private String sportName;
    private int classPrice;
    private String passType;
    private int discount;
    private int finalPrice;


    public PlayerPassDTO() {
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

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
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
        return "PlayerPassDTO{" +
                "purchaseDate=" + purchaseDate +
                ", sportName='" + sportName + '\'' +
                ", classPrice=" + classPrice +
                ", passType='" + passType + '\'' +
                ", discount=" + discount +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
