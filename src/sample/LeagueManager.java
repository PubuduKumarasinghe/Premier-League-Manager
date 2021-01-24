package sample;

import java.io.IOException;

public interface LeagueManager {
    void createNewFootballClub() throws IOException, ClassNotFoundException;
    void deleteFootballClub() throws IOException, ClassNotFoundException;
    void displayStats() throws IOException, ClassNotFoundException;
    void printPremierLeagueTable();
    void addNewMatchDetails() throws IOException, ClassNotFoundException;
    void DisplayLeagueTable();
}
