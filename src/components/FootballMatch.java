package components;

import java.io.Serializable;
import java.util.Date;

public class FootballMatch implements Serializable {
    private String team1;
    private String team2;
    private int team1Score;
    private int team2Score;
    private Date matchDate;

    public FootballMatch(String team1, String team2, int team1Score, int team2Score, Date matchDate) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.matchDate = matchDate;
    }

    public FootballMatch() {
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public String toString() {
        return "FootballMatch{" +
                "team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", team1Score=" + team1Score +
                ", team2Score=" + team2Score +
                ", matchDate=" + matchDate +
                '}';
    }
}
