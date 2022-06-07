package hu.elte.sportfoglalas.application.webdomain;

import java.util.Objects;

public class CourtDTO {
    private String name;

    private String sport;



    public CourtDTO() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourtDTO courtDTO = (CourtDTO) o;
        return Objects.equals(name, courtDTO.name) && Objects.equals(sport, courtDTO.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sport);
    }
}
