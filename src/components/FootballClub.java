package components;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Serializable {
    private int noOfClubWins;
    private int noOfClubLosses;
    private int noOfClubDraws;
    private int noOfGoalsScored;
    private int noOfGoalsReceived;
    private int noOfClubPoints;
    private int noOfMatchesPlayed;

    public FootballClub(String club_Name, String club_Location, int noOfClubWins, int noOfClubLosses, int noOfClubDraws, int noOfGoalsScored, int noOfGoalsReceived, int noOfClubPoints, int noOfMatchesPlayed) {
        super(club_Name, club_Location);
        this.noOfClubWins = noOfClubWins;
        this.noOfClubLosses = noOfClubLosses;
        this.noOfClubDraws = noOfClubDraws;
        this.noOfGoalsScored = noOfGoalsScored;
        this.noOfGoalsReceived = noOfGoalsReceived;
        this.noOfClubPoints = noOfClubPoints;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    public int getNoOfClubWins() {
        return noOfClubWins;
    }

    public void setNoOfClubWins(int noOfClubWins) {
        this.noOfClubWins = noOfClubWins;
    }

    public int getNoOfClubLosses() {
        return noOfClubLosses;
    }

    public void setNoOfClubLosses(int noOfClubLosses) {
        this.noOfClubLosses = noOfClubLosses;
    }

    public int getNoOfClubDraws() {
        return noOfClubDraws;
    }

    public void setNoOfClubDraws(int noOfClubDraws) {
        this.noOfClubDraws = noOfClubDraws;
    }

    public int getNoOfGoalsScored() {
        return noOfGoalsScored;
    }

    public void setNoOfGoalsScored(int noOfGoalsScored) {
        this.noOfGoalsScored = noOfGoalsScored;
    }

    public int getNoOfGoalsReceived() {
        return noOfGoalsReceived;
    }

    public void setNoOfGoalsReceived(int noOfGoalsReceived) {
        this.noOfGoalsReceived = noOfGoalsReceived;
    }

    public int getNoOfClubPoints() {
        return noOfClubPoints;
    }

    public void setNoOfClubPoints(int noOfClubPoints) {
        this.noOfClubPoints = noOfClubPoints;
    }

    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    @Override
    public String toString() {
        return "FootballClub{" + super.toString() +
                "noOfClubWins=" + noOfClubWins +
                ", noOfClubLosses=" + noOfClubLosses +
                ", noOfClubDraws=" + noOfClubDraws +
                ", noOfGoalsScored=" + noOfGoalsScored +
                ", noOfGoalsReceived=" + noOfGoalsReceived +
                ", noOfClubPoints=" + noOfClubPoints +
                ", noOfMatchesPlayed=" + noOfMatchesPlayed +
                '}';
    }
}
