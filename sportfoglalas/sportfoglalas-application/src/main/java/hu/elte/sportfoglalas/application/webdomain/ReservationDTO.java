package hu.elte.sportfoglalas.application.webdomain;

import java.util.Objects;

public class ReservationDTO {

    private String sportName;

    private String courtName;

    private String coach;

    private String startTime;

    private boolean passUsed;



    public ReservationDTO() {

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

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public boolean isPassUsed() {
        return passUsed;
    }

    public void setPassUsed(boolean passUsed) {
        this.passUsed = passUsed;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDTO that = (ReservationDTO) o;
        return Objects.equals(sportName, that.sportName) && Objects.equals(courtName, that.courtName) && Objects.equals(coach, that.coach) && Objects.equals(startTime, that.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportName, courtName, coach, startTime);
    }
}
