package hu.elte.sportfoglalas.application.webdomain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CoachClassesDTO {
    private String date;
    private String hour;
    private String sportName;
    private String courtName;
    private String playerName;


    public CoachClassesDTO() {
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}