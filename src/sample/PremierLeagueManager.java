package sample;

import components.FootballClub;
import components.FootballMatch;
import components.Sort;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {
    ArrayList<FootballClub> leagueClubs = new ArrayList<FootballClub>();
    private Sort sortAlgo = new Sort();
    private ArrayList<FootballMatch> playedMatches = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    @Override
    public void createNewFootballClub() throws IOException, ClassNotFoundException {
        String choice = "Y";

        while (choice.equals("Y")) {
            System.out.println("||*********************************************************||");
            System.out.println("||                CREATE NEW FOOTBALL CLUB                 ||");
            System.out.println("||*********************************************************||");
            try {
                System.out.print("Enter Club Name: ");
                String club_Name = sc.next();
                System.out.print("Enter Club Location: ");
                String club_Location = sc.next();
                System.out.print("Enter Number of Wins: ");
                int noOfClubWins = sc.nextInt();
                while (noOfClubWins < 0) {
                    System.out.println("Needs to be a Positive Number. Please Re-Enter");
                    System.out.println("Enter Number of Wins: ");
                    noOfClubWins = sc.nextInt();
                }
                System.out.print("Enter Number of Defeats: ");
                int noOfClubLosses = sc.nextInt();
                while (noOfClubLosses < 0) {
                    System.out.println("Needs to be a Positive Number. Please Re-Enter");
                    System.out.println("Enter Number of Defeats: ");
                    noOfClubLosses = sc.nextInt();
                }
                System.out.print("Enter Number of Draws: ");
                int noOfClubDraws = sc.nextInt();
                while (noOfClubDraws < 0) {
                    System.out.println("Needs to be a Positive Number. Please Re-Enter");
                    System.out.println("Enter Number of Draws: ");
                    noOfClubDraws = sc.nextInt();
                }
                System.out.print("Enter Number of Goals Scored: ");
                int noOfGoalsScored = sc.nextInt();
                while (noOfGoalsScored < 0) {
                    System.out.println("Needs to be a Positive Number. Please Re-Enter");
                    System.out.println("Enter Number of Goals Scored: ");
                    noOfGoalsScored = sc.nextInt();
                }
                System.out.print("Enter Number of Goals Received: ");
                int noOfGoalsReceived = sc.nextInt();
                while (noOfGoalsReceived < 0) {
                    System.out.println("Needs to be a Positive Number. Please Re-Enter");
                    System.out.println("Enter Number of Goals Received: ");
                    noOfGoalsReceived = sc.nextInt();
                }
                System.out.print("Enter Number of Points : ");
                int noOfClubPoints = sc.nextInt();
                while (noOfClubPoints < 0) {
                    System.out.println("Needs to be a Positive Number. Please Re-Enter");
                    System.out.println("Enter Number of Points: ");
                    noOfClubPoints = sc.nextInt();
                }
                System.out.print("Enter Number of Matches Played: ");
                int noOfMatchesPlayed = sc.nextInt();
                while (noOfMatchesPlayed < 0) {
                    System.out.println("Needs to be a Positive Number. Please Re-Enter");
                    System.out.println("Enter Number of Matches Played: ");
                    noOfMatchesPlayed = sc.nextInt();
                }

                FootballClub footballClub = new FootballClub(club_Name, club_Location,
                        noOfClubWins, noOfClubDraws, noOfClubLosses, noOfGoalsScored, noOfGoalsReceived,
                        noOfClubPoints, noOfMatchesPlayed);
                leagueClubs.add(footballClub);
                System.out.println("SUCCESSFULLY ADDED " + club_Name + " CLUB!");
                System.out.println();
                System.out.println("Would you like to add another Football Club again? Y/N");
                choice = sc.next().toUpperCase();

            } catch (InputMismatchException exception) {
                System.out.println("Wrong Input Please Re-Enter");
                choice = "Y";
            }
        }
        Main.Menu();
    }

    @Override
    public void addNewMatchDetails() throws IOException, ClassNotFoundException {
        System.out.println("||*********************************************************||");
        System.out.println("||                      ADD NEW MATCH                      ||");
        System.out.println("||*********************************************************||");
        System.out.println("Enter Match Date (format dd-mm-yyyy) eg. 04/04/2004: ");
        String line = sc.next();
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(line);
        } catch (ParseException ex) {
            System.out.println("You have to enter date in format mm-dd-yyyy eg. 04/04/2004");
            return;
        }
        System.out.println("Enter Team 1: ");
        String club1Name = sc.next();
        FootballClub team1 = null;
        for (FootballClub footballClub : leagueClubs) {
            if (footballClub.getClub_Name().equalsIgnoreCase(club1Name)) {
                team1 = footballClub;
                System.out.println(team1);
            }
        }

        System.out.println("Enter Team 2: ");
        String club2Name = sc.next();
        FootballClub team2 = null;
        for (FootballClub footballClub : leagueClubs) {
            if (footballClub.getClub_Name().equalsIgnoreCase(club2Name)) {
                team2 = footballClub;
                System.out.println(team2);
            }
        }

        System.out.println("Enter Team 1 goals: ");
        int team1Goals = sc.nextInt();

        System.out.println("Enter Team 2 goals: ");
        int team2Goals = sc.nextInt();


        FootballMatch match = new FootballMatch(team1.getClub_Name(), team2.getClub_Name(), team1Goals, team2Goals, date);
        playedMatches.add(match);
        team1.setNoOfGoalsScored(team1.getNoOfGoalsScored() + team1Goals);
        team2.setNoOfGoalsScored(team2.getNoOfGoalsScored() + team2Goals);
        team1.setNoOfGoalsReceived(team1.getNoOfGoalsReceived() + team2Goals);
        team2.setNoOfGoalsReceived(team2.getNoOfGoalsReceived() + team1Goals);
        team1.setNoOfMatchesPlayed(team1.getNoOfMatchesPlayed() + 1);
        team2.setNoOfMatchesPlayed(team2.getNoOfMatchesPlayed() + 1);

        if (team1Goals > team2Goals) {
            team1.setNoOfClubPoints(team1.getNoOfClubPoints() + 3);
            team1.setNoOfClubWins(team1.getNoOfClubWins() + 1);
            team2.setNoOfClubLosses(team2.getNoOfClubLosses() + 1);
        } else if (team1Goals < team2Goals) {
            team2.setNoOfClubPoints(team2.getNoOfClubPoints() + 3);
            team2.setNoOfClubWins(team2.getNoOfClubWins() + 1);
            team1.setNoOfClubLosses(team1.getNoOfClubLosses() + 1);
        } else {
            team1.setNoOfClubPoints(team1.getNoOfClubPoints() + 1);
            team2.setNoOfClubPoints(team2.getNoOfClubPoints() + 1);
            team1.setNoOfClubDraws(team1.getNoOfClubDraws() + 1);
            team2.setNoOfClubDraws(team2.getNoOfClubDraws() + 1);
        }

        System.out.println("Match Details Added!");
        Main.Menu();
    }

    @Override
    public void printPremierLeagueTable() {
        System.out.println("BELOW SHOWS THE CLUB DETAILS IN THE DESCENDING ODER OF POINTS!");
        String leftAlignFormat = "%-15s | %-4d |%n";
        leagueClubs.sort(sortAlgo.sortByPoints);

        System.out.format("+-----------------+------+%n");
        System.out.format("|Club Names     |Points|%n");
        System.out.format("+-----------------+------+%n");
        for (int i = 0; i < leagueClubs.size(); i++) {
            System.out.format(leftAlignFormat, leagueClubs.get(i).getClub_Name(),
                    leagueClubs.get(i).getNoOfClubPoints());
        }
        System.out.format("+-----------------+------+%n");
    }

    @Override
    public void displayStats() throws IOException, ClassNotFoundException {
        String choice = "Y";

        while (choice.equals("Y")) {
            System.out.println("||*********************************************************||");
            System.out.println("||                   DISPLAY CLUB DETAILS                  ||");
            System.out.println("||*********************************************************||");
            System.out.print("  Enter Club Name: ");
            String clubName = sc.next().toUpperCase();

            for (FootballClub footballClub : leagueClubs) {
                if (footballClub.getClub_Name().equalsIgnoreCase(clubName)) {
                    System.out.println(
                            "+------+-------+---------+----------------+--------------+--------+----------------+");
                    System.out.println(
                            "| Wins | Draws | Losses | Goals Received | Goals Scored | Points | Matched Played |");
                    System.out.println(
                            "+------+-------+---------+----------------+--------------+--------+----------------+");
                    System.out.println(
                            "| " + footballClub.getNoOfClubWins() + "    | " + footballClub.getNoOfClubDraws() + "     | "
                                    + footballClub.getNoOfClubLosses() + "  "
                                    + "     | " + footballClub.getNoOfGoalsReceived() + "              | " + footballClub
                                    .getNoOfGoalsScored() + ""
                                    + "            | " + footballClub.getNoOfClubPoints() + "      | " + footballClub
                                    .getNoOfMatchesPlayed() + "              |");
                    System.out.println(
                            "+------+-------+---------+----------------+--------------+--------+----------------+");
                } else {
                    System.out.println("There is no Club with that Name");
                }
            }

            System.out.print("  Would You Like to Display Stats of another CLub? (Y/N) ");
            choice = sc.next().toUpperCase();
        }
        Main.Menu();

    }

    @Override
    public void deleteFootballClub() throws IOException, ClassNotFoundException {
        String choice = "Y";
        while (choice.equals("Y")) {
            System.out.println("||*********************************************************||");
            System.out.println("||                 DELETE A FOOTBALL CLUB                  ||");
            System.out.println("||*********************************************************||");
            System.out.println("Following are the Football Clubs available.");
            System.out.println(leagueClubs);
            System.out.println("  Enter Name of Club: ");
            String clubName = sc.next();
            for (int i = 0; i < leagueClubs.size(); i++) {
                if (leagueClubs.get(i).getClub_Name().equalsIgnoreCase(clubName)) {
                    leagueClubs.remove(i);
                    System.out.println("You have successfully deleted" + clubName + "from the Premier League");
                    System.out.println("Would You like to Delete another Club? (Y/N)");
                    choice = sc.next();
                } else {
                    System.out.println("Club Doesnt Exist");
                }
            }
        }
        Main.Menu();
    }

    public ArrayList<FootballClub> getLeagueClubs() {
        return leagueClubs;
    }

    public ArrayList<FootballMatch> getPlayedMatches() {
        return playedMatches;
    }

    public void LoadClubData() throws IOException, ClassNotFoundException {
        File file = new File("ClubDataFile.txt");
        try {
            if (file.length() != 0) {
                FileInputStream fileInputSt = new FileInputStream("ClubDataFile.txt");
                ObjectInputStream objectInputSt = new ObjectInputStream(fileInputSt);
                for (; ; ) {
                    try {
                        leagueClubs.add((FootballClub) objectInputSt.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }
                System.out.println(leagueClubs);
                System.out.println("Previous data has been loaded successfully");
            } else {
                Main.Menu();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void LoadMatchData() throws IOException, ClassNotFoundException {
        File file = new File("MatchDataFile.txt");
        try {
            if (file.length() != 0) {
                FileInputStream fileInputSt = new FileInputStream("MatchDataFile.txt");
                ObjectInputStream objectInputSt = new ObjectInputStream(fileInputSt);

                for (; ; ) {
                    try {
                        playedMatches.add((FootballMatch) objectInputSt.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }
                System.out.println("Previous data has been loaded successfully");
            } else {
                Main.Menu();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void DisplayLeagueTable() {
        System.out.println(getLeagueClubs());
        Font font = new Font("Roboto", 12);

        Scanner scannr = new Scanner(System.in);
        for (FootballClub footballClub : leagueClubs) {
            System.out.println(footballClub);
        }
        System.out.println("");
        System.out.println("Opening the GUI. please wait..");

        final HBox hb = new HBox();
        Stage stage = new Stage();

        GridPane pane = new GridPane();
//        pane.setStyle("-fx-background-image: url('https://images4.alphacoders.com/932/932935.jpg');" + "-fx-background-size: cover;");
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(15);

        Text scenetitle = new Text("Premier league Table");
        scenetitle.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 35));
        hb.getChildren().add(scenetitle);
        hb.setAlignment(Pos.CENTER);
        pane.add(hb, 0, 0);

        ComboBox combo_box = new ComboBox();
        combo_box.getItems().add("Sort By Points");
        combo_box.getItems().add("Sort By Goal Score");
        combo_box.getItems().add("Sort By Wins");
        combo_box.getSelectionModel().selectFirst();
        String Vlaue = (String) combo_box.getValue();

        Text sort = new Text("Sort Option : ");
        sort.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 14));
        HBox hbox = new HBox();
        hbox.getChildren().addAll(sort, combo_box);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        pane.add(hbox, 0, 2);

        TableView tableView = new TableView();

        TableColumn<String, FootballClub> column0 = new TableColumn<>("Name");
        column0.setCellValueFactory(new PropertyValueFactory<>("club_Name"));
        tableView.getColumns().add(column0);

        TableColumn<String, FootballClub> locationColumn = new TableColumn<>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("club_Location"));
        tableView.getColumns().add(locationColumn);

        TableColumn<Integer, FootballClub> winsColumn = new TableColumn<>("Club Wins");
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("noOfClubWins"));
        tableView.getColumns().add(winsColumn);

        TableColumn<Integer, FootballClub> drawsColumn = new TableColumn<>("Club Draws");
        drawsColumn.setCellValueFactory(new PropertyValueFactory<>("noOfClubDraws"));
        tableView.getColumns().add(drawsColumn);

        TableColumn<Integer, FootballClub> defeatsColumn = new TableColumn<>("Club Defeats");
        defeatsColumn.setCellValueFactory(new PropertyValueFactory<>("noOfClubLosses"));
        tableView.getColumns().add(defeatsColumn);

        TableColumn<Integer, FootballClub> playedMatchesColumn = new TableColumn<>("No. Matches Played");
        playedMatchesColumn.setCellValueFactory(new PropertyValueFactory<>("noOfMatchesPlayed"));
        tableView.getColumns().add(playedMatchesColumn);

        TableColumn<Integer, FootballClub> goalRecievedColumn = new TableColumn<>("No. of Goals Received");
        goalRecievedColumn.setCellValueFactory(new PropertyValueFactory<>("noOfGoalsReceived"));
        tableView.getColumns().add(goalRecievedColumn);

        TableColumn<Integer, FootballClub> goalsScoredColumn = new TableColumn<>("No. of Goals Scored");
        goalsScoredColumn.setCellValueFactory(new PropertyValueFactory<>("noOfGoalsScored"));
        tableView.getColumns().add(goalsScoredColumn);

        TableColumn<Integer, FootballClub> pointsColumn = new TableColumn<>("No. of Points");
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("noOfClubPoints"));
        tableView.getColumns().add(pointsColumn);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        leagueClubs.sort(sortAlgo.sortByPoints);
        for (FootballClub footballClub : leagueClubs) {
            System.out.println(footballClub);
            tableView.getItems().add(footballClub);
        }

        EventHandler<ActionEvent> Event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tableView.getItems().clear();
                String Value = (String) combo_box.getValue();
                if (Value.equals("Sort By Points")) {
                    tableView.getItems().clear();
                    leagueClubs.sort(sortAlgo.sortByPoints);
                    for (FootballClub footballClub : leagueClubs) {
                        tableView.getItems().add(footballClub);
                    }
                } else if (Value.equals("Sort By Goal Score")) {
                    tableView.getItems().clear();
                    leagueClubs.sort(sortAlgo.sortByScore);
                    for (FootballClub footballClub : leagueClubs) {
                        tableView.getItems().add(footballClub);
                    }
                } else if (Value.equals("Sort By Wins")) {
                    tableView.getItems().clear();
                    leagueClubs.sort(sortAlgo.sortByWins);
                    for (FootballClub footballClub : leagueClubs) {
                        tableView.getItems().add(footballClub);
                    }
                }
            }
        };
        combo_box.setOnAction(Event);

        pane.add(tableView, 0, 3);
        Scene Scene = new Scene(pane, 800, 770);
        stage.setScene(Scene);
        stage.showAndWait();
    }

    public void AddMatch() throws Exception {
        try {
            Scanner scan = new Scanner(System.in);
            Stage stage = new Stage();
            GridPane pane = new GridPane();
//            pane.setStyle("-fx-background-image: url('https://images4.alphacoders.com/932/932935.jpg');" + "-fx-background-size: cover;");
            pane.setVgap(15);
            pane.setAlignment(Pos.CENTER);

            HBox hboX = new HBox();
            Text scenetitle = new Text("Add Match");
            scenetitle.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 35));
            hboX.getChildren().add(scenetitle);
            hboX.setAlignment(Pos.CENTER);
            pane.add(hboX, 0, 0);

            HBox hbox = new HBox();
            final Label label = new Label("Add match date ");
            label.setFont(new Font("Roboto", 20));

            DatePicker datePicker = new DatePicker();

            Button button = new Button("Add");
            button.setOnMouseExited(e -> button.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%), linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);-fx-font-size: 1.1em;"));
            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);"));
            button.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%), linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);-fx-font-size: 1.1em;");

            button.setPrefSize(100, 25);
            button.setOnAction(action -> {
                if (datePicker.getValue() != null) {
                    HBox hboxx = new HBox();
                    FootballMatch footBallMatch = new FootballMatch();
                    Date date;

                    String DateM = datePicker.getValue().toString();
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(DateM);
                    } catch (ParseException ex) {
                        System.out.println(DateM);
                        System.out.println("You have to enter date in format mm-dd-yyyy eg. 04/04/2004");
                        return;
                    }
                    footBallMatch.setMatchDate(date);

                    if (leagueClubs.size() < 2) {
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setContentText("there are not enough teams to add match !!");
                        a.setHeaderText("ERROR");
                        a.show();

                        System.out.println("there are not enough teams to add match");
                        System.out.println(" ");

                    } else {
                        Random random = new Random();
                        int randomteam;
                        int randomteamB;

                        do {
                            randomteam = random.nextInt(leagueClubs.size());
                            randomteamB = random.nextInt(leagueClubs.size());
                        }
                        while (randomteam == randomteamB);

                        FootballClub team1 = leagueClubs.get(randomteam);
                        footBallMatch.setTeam1Score(randomteam);
                        FootballClub team2 = leagueClubs.get(randomteamB);
                        footBallMatch.setTeam2Score(randomteamB);

                        footBallMatch.setTeam1(team1.getClub_Name());
                        footBallMatch.setTeam2(team2.getClub_Name());

                        int randomGoalsA = random.nextInt(5);
                        int randomGoalsB = random.nextInt(5);

                        footBallMatch.setTeam1Score(randomGoalsA);
                        footBallMatch.setTeam2Score(randomGoalsB);

                        team1.setNoOfGoalsScored(team1.getNoOfGoalsScored() + randomGoalsA);
                        team2.setNoOfGoalsScored(team2.getNoOfGoalsScored() + randomGoalsB);
                        team1.setNoOfGoalsReceived(team1.getNoOfGoalsReceived() + randomGoalsB);
                        team2.setNoOfGoalsReceived(team2.getNoOfGoalsReceived() + randomGoalsA);
                        team1.setNoOfMatchesPlayed(team1.getNoOfMatchesPlayed() + 1);
                        team2.setNoOfMatchesPlayed(team2.getNoOfMatchesPlayed() + 1);

                        if (randomGoalsA > randomGoalsB) {
                            team1.setNoOfClubPoints(team1.getNoOfClubPoints() + 3);
                            team1.setNoOfClubWins(team1.getNoOfClubWins() + 1);
                            team2.setNoOfClubLosses(team2.getNoOfClubLosses() + 1);
                        } else if (randomGoalsA < randomGoalsB) {
                            team2.setNoOfClubPoints(team2.getNoOfClubPoints() + 3);
                            team2.setNoOfClubWins(team2.getNoOfClubWins() + 1);
                            team1.setNoOfClubLosses(team1.getNoOfClubLosses() + 1);
                        } else {
                            team1.setNoOfClubPoints(team1.getNoOfClubPoints() + 1);
                            team2.setNoOfClubPoints(team2.getNoOfClubPoints() + 1);
                            team1.setNoOfClubDraws(team1.getNoOfClubDraws() + 1);
                            team2.setNoOfClubDraws(team2.getNoOfClubDraws() + 1);
                        }
                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText("Succesfully added a New Match between " + team1.getClub_Name() + " and " + team2.getClub_Name());
                        a.setHeaderText("Success");
                        a.show();
                        playedMatches.add(footBallMatch);
                    }

                    hboxx.setAlignment(Pos.CENTER);
                    pane.add(hboxx, 0, 2);
                } else {
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setContentText("Empty Date !!");
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setHeaderText("ERROR!!");
                    a.show();
                }
            });

            Font font = new Font("Roboto",12);
            Button back = new Button("Back");
            back.setOnMouseExited(e -> back.setStyle("-fx-background-color: linear-gradient(red,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
            back.setOnMouseEntered(e -> back.setStyle("-fx-background-color: linear-gradient(red,saddlebrown); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
            back.setStyle("-fx-background-color: linear-gradient(red,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
            back.setFont(font);
            back.setPrefSize(100,25);
            back.setOnAction(actionEvent -> {
                stage.close();
            });

            pane.add(back,3,7);
            hbox.getChildren().addAll(label,datePicker,button);
            hbox.setSpacing(15);
            pane.add(hbox,0,1);

            Scene scene = new Scene(pane,800,770);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void matchTable(){
        Stage stage = new Stage();
        GridPane pane = new GridPane();
        GridPane newPane = new GridPane();
//        pane.setStyle("-fx-background-image: url('https://images4.alphacoders.com/932/932935.jpg');" + "-fx-background-size: cover;");
        pane.setVgap(15);
        pane.setAlignment(Pos.CENTER);

        HBox hboX = new HBox();
        Text scenetitle = new Text("Match Table");
        scenetitle.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 35));
        hboX.getChildren().add(scenetitle);
        hboX.setAlignment(Pos.CENTER);
        pane.add(hboX,0,0);

        TableView tableView = new TableView();

        TableColumn<Date,FootballMatch> column = new TableColumn<>("Date");
        column.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
        tableView.getColumns().add(column);

        TableColumn<String, FootballMatch> column1 = new TableColumn<>("Team 1");
        column1.setCellValueFactory(new PropertyValueFactory<>("team1"));
        tableView.getColumns().add(column1);

        TableColumn<Integer, FootballMatch> column2 = new TableColumn<>("Team 1 Score");
        column2.setCellValueFactory(new PropertyValueFactory<>("team1Score"));
        tableView.getColumns().add(column2);

        TableColumn<String, FootballMatch> column3 = new TableColumn<>("Team 2");
        column3.setCellValueFactory(new PropertyValueFactory<>("team2"));
        tableView.getColumns().add(column3);

        TableColumn<Integer, FootballMatch> column4 = new TableColumn<>("Team 2 Score");
        column4.setCellValueFactory(new PropertyValueFactory<>("team2Score"));
        tableView.getColumns().add(column4);

        for (FootballMatch match : playedMatches) {
            tableView.getItems().add(match);
        }

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Button back = new Button("Back");
        back.setOnMouseExited(e -> back.setStyle("-fx-background-color: linear-gradient(red,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
        back.setOnMouseEntered(e -> back.setStyle("-fx-background-color: linear-gradient(red,saddlebrown); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        back.setStyle("-fx-background-color: linear-gradient(red,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
        back.setPrefSize(100,25);
        back.setOnAction(actionEvent -> {
            stage.close();
        });

        HBox hboxx = new HBox();
        tableView.setPrefSize(500,400);

        hboxx.getChildren().add(tableView);
        hboxx.setAlignment(Pos.CENTER);
        pane.add(hboxx,0,2);
        pane.add(back,3,4);

        Scene scene = new Scene(pane,800,770);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void FindMatch() {
        Stage stage = new Stage();
        GridPane pane = new GridPane();
        pane.setVgap(15);
        pane.setAlignment(Pos.CENTER);
        HBox hboX = new HBox();
        Text scenetitle = new Text("Find Match");
        scenetitle.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 35));
        hboX.getChildren().add(scenetitle);
        hboX.setAlignment(Pos.CENTER);
        pane.add(hboX, 0, 0);

        Button back = new Button("Back");
        back.setOnMouseExited(e -> back.setStyle("-fx-background-color: linear-gradient(red,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
        back.setOnMouseEntered(e -> back.setStyle("-fx-background-color: linear-gradient(red,saddlebrown); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        back.setStyle("-fx-background-color: linear-gradient(red,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
        back.setPrefSize(100,25);
        back.setOnAction(actionEvent -> {
            stage.close();
        });

        HBox hbox = new HBox();
        final Label label = new Label("Enter the Date of the Match ");
        label.setFont(new Font("Roboto", 20));
        DatePicker datePicker = new DatePicker();

        Button button = new Button("Find");
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%), linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);-fx-font-size: 1.1em;"));
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);"));
        button.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%), linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);-fx-font-size: 1.1em;");

        button.setPrefSize(100, 25);
        button.setOnAction(action -> {

            TableView tableView = new TableView();
            TableColumn<Date,FootballMatch> column = new TableColumn<>("Date");
            column.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
            tableView.getColumns().add(column);

            TableColumn<String, FootballMatch> column1 = new TableColumn<>("Team 1");
            column1.setCellValueFactory(new PropertyValueFactory<>("team1"));
            tableView.getColumns().add(column1);

            TableColumn<Integer, FootballMatch> column2 = new TableColumn<>("Team 1 Score");
            column2.setCellValueFactory(new PropertyValueFactory<>("team1Score"));
            tableView.getColumns().add(column2);

            TableColumn<String, FootballMatch> column3 = new TableColumn<>("Team 2");
            column3.setCellValueFactory(new PropertyValueFactory<>("team2"));
            tableView.getColumns().add(column3);

            TableColumn<Integer, FootballMatch> column4 = new TableColumn<>("Team 2 Score");
            column4.setCellValueFactory(new PropertyValueFactory<>("team2Score"));
            tableView.getColumns().add(column4);
            tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


            String DateM = String.valueOf(datePicker.getValue());
            tableView.getItems().clear();

            for (FootballMatch matches : playedMatches) {
                Instant datePlayed = matches.getMatchDate().toInstant();
                ZonedDateTime zdt = datePlayed.atZone(ZoneId.systemDefault());
                LocalDate date = zdt.toLocalDate();
                System.out.println(DateM + "  " + date);
                if (date.toString().equals(DateM)){
                    tableView.getItems().add(matches);
                }
            }
            HBox hboxx = new HBox();
            tableView.setPrefSize(500,400);
            hboxx.getChildren().add(tableView);
            hboxx.setAlignment(Pos.CENTER);
            pane.add(hboxx,0,2);
        });

        pane.add(back,3,6);

        hbox.getChildren().addAll(label,datePicker,button);
        hbox.setSpacing(15);
        pane.add(hbox,0,1);

        Scene scene = new Scene(pane,800,770);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
