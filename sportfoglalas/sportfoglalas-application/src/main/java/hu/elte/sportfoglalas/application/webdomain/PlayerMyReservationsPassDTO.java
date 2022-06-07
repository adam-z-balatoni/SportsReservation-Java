package hu.elte.sportfoglalas.application.webdomain;

public class PlayerMyReservationsPassDTO {
    String sportName;
    int remainingReservations;
    String discount;



    public PlayerMyReservationsPassDTO() {
    }


    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public int getRemainingReservations() {
        return remainingReservations;
    }

    public void setRemainingReservations(int remainingReservations) {
        this.remainingReservations = remainingReservations;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
