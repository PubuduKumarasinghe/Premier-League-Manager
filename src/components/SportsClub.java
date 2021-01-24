package components;

import java.io.Serializable;

public class SportsClub implements Serializable {
    private String club_Name;
    private String club_Location;

    public SportsClub(String club_Name, String club_Location) {
        this.club_Name = club_Name;
        this.club_Location = club_Location;
    }

    public SportsClub() {
    }

    public String getClub_Name() {
        return club_Name;
    }

    public void setClub_Name(String club_Name) {
        this.club_Name = club_Name;
    }

    public String getClub_Location() {
        return club_Location;
    }

    public void setClub_Location(String club_Location) {
        this.club_Location = club_Location;
    }

    @Override
    public String toString() {
        return "SportsClub{" +
                "club_Name='" + club_Name + '\'' +
                ", club_Location='" + club_Location + '\'' +
                '}';
    }
}
