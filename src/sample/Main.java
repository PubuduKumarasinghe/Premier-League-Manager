package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    private static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    private static Storage storage = new Storage();
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void start(Stage primaryStage) throws Exception{
        premierLeagueManager.LoadClubData();
        premierLeagueManager.LoadMatchData();
        Menu();
    }

    public static void GUIInterface(){
        Stage stage = new Stage();
        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-image: url('https://wallpapercave.com/wp/wp3183523.jpg');" + "-fx-background-size: cover;");
        stage.setTitle("Premier League Manager");
        Font font = new Font("Roboto",12);
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(45);
        Text scenetitle = new Text("PREMIER LEAGUE MANAGER");
        scenetitle.setFill(Color.WHITE);
        scenetitle.setFont(Font.font("Roboto", FontWeight.BLACK, 45));
        scenetitle.setTextAlignment(TextAlignment.CENTER);
        pane.add(scenetitle,1,1,2,1);
        VBox vbox = new VBox();


        Button TableDisplayBUtton = new Button("LEAGUE TABLE");
        TableDisplayBUtton.setOnMouseExited(e -> TableDisplayBUtton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
        TableDisplayBUtton.setOnMouseEntered(e -> TableDisplayBUtton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1em;"));
        TableDisplayBUtton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
        TableDisplayBUtton.setFont(font);
        TableDisplayBUtton.setPrefSize(120,50);
        TableDisplayBUtton.setOnAction(actionEvent -> {
            premierLeagueManager.DisplayLeagueTable();
        });

        Button matchButton = new Button("ADD MATCH");
        matchButton.setOnMouseExited(e ->matchButton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.2em;"));
        matchButton.setOnMouseEntered(e -> matchButton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        matchButton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.2em;");
        matchButton.setFont(font);
        matchButton.setPrefSize(120,50);
        matchButton.setOnAction(actionEvent -> {
            try {
                premierLeagueManager.AddMatch();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button matchTable = new Button("MATCH TABLE");
        matchTable.setOnMouseExited(e -> matchTable.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.2em;"));
        matchTable.setOnMouseEntered(e -> matchTable.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        matchTable.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.2em;");
        matchTable.setFont(font);
        matchTable.setPrefSize(120,50);
        matchTable.setOnAction(actionEvent -> {
            premierLeagueManager.matchTable();
        });

        Button FindButton = new Button("FIND MATCH");
        FindButton.setOnMouseExited(e -> FindButton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.2em;"));
        FindButton.setOnMouseEntered(e -> FindButton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        FindButton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.2em;");
        FindButton.setFont(font);
        FindButton.setPrefSize(120,50);
        FindButton.setOnAction(actionEvent -> {
            premierLeagueManager.FindMatch();
        });

        Button Save = new Button("SAVE");
        Save.setOnMouseExited(e -> Save.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.2em;"));
        Save.setOnMouseEntered(e -> Save.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        Save.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.3em;");
        Save.setFont(font);
        Save.setPrefSize(120,50);
        Save.setOnAction(actionEvent -> {
            Storage storage = new Storage();
            storage.SaveFile(premierLeagueManager.getLeagueClubs());
            storage.SaveMatch(premierLeagueManager.getPlayedMatches());
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Saved Successfully !!");
            a.setHeaderText("DONE");
            a.show();
        });

        Button QuitButton = new Button("QUIT");
        QuitButton.setOnMouseEntered(e -> QuitButton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        QuitButton.setOnMouseExited(e -> QuitButton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.3em;"));
        QuitButton.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.3em;");
        QuitButton.setFont(font);
        QuitButton.setPrefSize(120,50);
        QuitButton.setOnAction(actionEvent -> {
            System.exit(1);
        });

        vbox.getChildren().addAll(TableDisplayBUtton,matchButton,matchTable,FindButton,Save,QuitButton);
        vbox.setAlignment(Pos.CENTER_RIGHT);
        vbox.setSpacing(20);
        pane.add(vbox,2,3);

        Scene scene = new Scene(pane,800,770);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void Menu() throws IOException, ClassNotFoundException {

        System.out.println("||*******************************************************||");
        System.out.println("||        WELCOME TO THE PREMIER LEAGUE MANAGER          ||");
        System.out.println("||*******************************************************||");
        System.out.println("||  Select from the below options.                       ||");
        System.out.println("||  A. Create a New Football Club                        ||");
        System.out.println("||  B. Delete a selected Football Club                 ||");
        System.out.println("||  C. Display Statistics of a Club                      ||");
        System.out.println("||  D. Display The Premier League Table                  ||");
        System.out.println("||  E. Add a Match Details                               ||");
        System.out.println("||  G. Open GUI                                          ||");
        System.out.println("||  S. Save Details                                      ||");
        System.out.println("||  Q. Exit                                              ||");
        System.out.println("||*******************************************************||\n");
        System.out.print("  Enter Option: ");
        String user_Input = sc.next().toUpperCase();

        switch (user_Input) {
            case "A":
                premierLeagueManager.createNewFootballClub();
                break;
            case "B":
                premierLeagueManager.deleteFootballClub();
                break;
            case "C":
                premierLeagueManager.displayStats();
                break;
            case "D":
                premierLeagueManager.printPremierLeagueTable();
                break;
            case "E":
                premierLeagueManager.addNewMatchDetails();
                break;
            case "G":
                GUIInterface();
                break;
            case "S":
                storage.SaveFile(premierLeagueManager.getLeagueClubs());
                storage.SaveMatch(premierLeagueManager.getPlayedMatches());
                break;
            case "Q":
                System.out.println("||*******************************************||");
                System.out.println("||     EXITED THE PREMIER LEAGUE MANAGER     ||");
                System.out.println("||*******************************************||");
                System.exit(1);
                break;
            default:
                System.err.println("Invalid Input. Try Again.");
                break;
        }
    }

}
