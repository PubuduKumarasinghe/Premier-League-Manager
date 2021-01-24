package components;

import java.util.Comparator;

public class Sort {
    public Comparator<FootballClub> sortByPoints = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub club1, FootballClub club2) {
            if (club1.getNoOfClubPoints() < club2.getNoOfClubPoints()) {
                return 1;
            } else if (club1.getNoOfClubPoints() > club2.getNoOfClubPoints()) {
                return -1;
            } else if (club1.getNoOfClubPoints() == club2.getNoOfClubPoints()) {
                int GoalDiff1 = club1.getNoOfClubPoints() - club1.getNoOfClubPoints();
                int GoalDiff2 = club2.getNoOfClubPoints() - club2.getNoOfClubPoints();
                if (GoalDiff1 < GoalDiff2) {
                    return 1;
                } else if (GoalDiff1 > GoalDiff2) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    };

    public Comparator<FootballClub> sortByScore = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub club1, FootballClub club2) {
            if (club1.getNoOfGoalsScored() < club2.getNoOfGoalsScored()) {
                return 1;
            } else if (club1.getNoOfGoalsScored() > club2.getNoOfGoalsScored()) {
                return -1;
            } else if (club1.getNoOfGoalsScored() == club2.getNoOfGoalsScored()) {
                int GoalDiff1 = club1.getNoOfGoalsScored()-club1.getNoOfGoalsScored();
                int GoalDiff2 = club2.getNoOfGoalsScored()-club2.getNoOfGoalsScored();
                if (GoalDiff1<GoalDiff2) {
                    return 1;
                } else if (GoalDiff1>GoalDiff2) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    };

    public Comparator<FootballClub> sortByWins = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub club1, FootballClub club2) {
            if (club1.getNoOfClubWins() < club2.getNoOfClubWins()) {
                return 1;
            } else if (club1.getNoOfClubWins() > club2.getNoOfClubWins()) {
                return -1;
            } else if (club1.getNoOfClubWins() == club2.getNoOfClubWins()) {
                int GoalDiff1 = club1.getNoOfClubWins()-club1.getNoOfClubWins();
                int GoalDiff2 = club2.getNoOfClubWins()-club2.getNoOfClubWins();
                if (GoalDiff1<GoalDiff2) {
                    return 1;
                } else if (GoalDiff1>GoalDiff2) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    };

}