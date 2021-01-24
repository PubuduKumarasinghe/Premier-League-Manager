package sample;

import components.FootballClub;
import components.FootballMatch;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    public void SaveFile(ArrayList<FootballClub> leagueClubs) {
        String filename="ClubDataFile.txt";
        try{
            ObjectOutputStream objectSaving =new ObjectOutputStream(new FileOutputStream(filename));
            for(FootballClub footballClub: leagueClubs){
                objectSaving.writeObject(footballClub);
            }
            objectSaving.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("The Club Data has been successfully stored in ClubDataFile.txt");
    }

    public void SaveMatch(ArrayList<FootballMatch> matches) {
        String file = "MatchDataFile.txt";
        try {
            ObjectOutputStream objectSaving = new ObjectOutputStream(new FileOutputStream(file));
            for (FootballMatch footballMatch : matches) {
                objectSaving.writeObject(footballMatch);
            }
            objectSaving.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The Match Data has been successfully stored in MatchDataFile.txt");
    }

}
