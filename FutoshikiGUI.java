
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import uk.ac.sussex.ianw.fp.futoshiki2.Futoshiki;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import uk.ac.sussex.ianw.fp.futoshiki2.FutoshikiSquare;

/**
 *
 * @author mkt22
 */
public class FutoshikiGUI extends Application {

    BorderPane borderpane;
    int grid;
    ButtonClass tile;
    Futoshiki ActualPuzzle;

    @Override
    public void start(Stage primaryStage) {

        Futoshiki ActualPuzzle;
        ActualPuzzle = new Futoshiki();

        Button btnStart;
        btnStart = new Button();
        btnStart.setText("Start new Game");

        Button btnLoad;
        btnLoad = new Button();
        btnLoad.setText("Load Game");
        btnLoad.setOnAction((ActionEvent ActionEvent) -> {
            try {
                checkGamesSaved();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(FutoshikiGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        Button btnSave;
        btnSave = new Button();
        btnSave.setText("Save Game");
        btnSave.setOnAction((ActionEvent ActionEvent) -> {
            saveGame();
            System.out.println("game saved");
        });

        Button btnhint;
        btnhint = new Button();
        btnhint.setText("Give us a hint");

        Button btnCheck;
        btnCheck = new Button();
        btnCheck.setText("Check");
        btnCheck.setOnAction((ActionEvent ActionEvent) -> {
            if (ActualPuzzle.isPuzzleSolved()) {

            }
            else if(ActualPuzzle.isPuzzleSolved() && ActualPuzzle.getProblems().equals("")){
                            Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Complete Game");
                alert.setHeaderText("Congrats you win  !");
                alert.setContentText("Please play again ");

                alert.showAndWait();
            
            }
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Unfinished Game");
                alert.setHeaderText("This game is not solved !");
                alert.setContentText("Please finish playing");

                alert.showAndWait();

            }
            

            ActualPuzzle.getProblems();
            System.out.println(ActualPuzzle.getProblems());
        });

        Button btnGiveUp;
        btnGiveUp = new Button();
        btnGiveUp.setText("I give up!");
        btnGiveUp.setOnAction((giveUp) -> {
                               Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Give up box");
                alert.setHeaderText("commiserations maybe next time  !");
                alert.setContentText("Please play again ");

                alert.showAndWait();
        });

        Button Clear;
        Clear = new Button();
        Clear.setText("Clear");
        Clear.setOnAction((event) -> {
            for (int i = 0; i < ActualPuzzle.gridSize; i++) {
                for (int j = 0; j < ActualPuzzle.gridSize; j++) {
                    if (ActualPuzzle.getSquare(i, j).isEditable()) {
                        ActualPuzzle.setSquare(i, j, 0);
                        borderpane.setCenter(NewGame(ActualPuzzle));
                    }
                }

            }

        });

        Button btnExit;
        btnExit = new Button();
        btnExit.setText("Exit Game");
        btnExit.setOnAction(actionEvent -> Platform.exit());

        TextField gridSizeInput = new TextField();

        Button btnSize;
        btnSize = new Button();
        btnSize.setText("Grid Size Confirmed");
        btnSize.setOnAction((e) -> {
            try {
                grid = Integer.valueOf(gridSizeInput.getText());
            } catch (NumberFormatException a) {
                System.out.println("nope");
                grid = 5;
            }
            Futoshiki fp = new Futoshiki(grid);
            fp.fillPuzzle(grid, grid, grid);
            Pane NewGame = NewGame(fp);
            borderpane.setCenter(NewGame(fp));
            System.out.println(fp.displayString());

            /* ActualPuzzle.fillPuzzle(5, 5, 5);
            Pane NewGame = NewGame(ActualPuzzle);
            borderpane.setCenter(NewGame(ActualPuzzle));*/
        });

        HBox hboxtopmenu;
        hboxtopmenu = new HBox();
        hboxtopmenu.getChildren().add(gridSizeInput);
        hboxtopmenu.getChildren().add(btnSize);
        hboxtopmenu.setPadding(new Insets(20, 50, 20, 150));
        hboxtopmenu.setSpacing(45);
        hboxtopmenu.setStyle("-fx-border-width: 3;"
                + "-fx-border-color: #118C42;" + "-fx-background-color: #75D79C;");
        //hboxtopmenu.setAlignment(Pos.CENTER);

        VBox vboxleftmenu;
        vboxleftmenu = new VBox();
        vboxleftmenu.setSpacing(15);
        vboxleftmenu.setPadding(new Insets(25, 15, 20, 15));
        vboxleftmenu.setStyle("-fx-border-width: 3;"
                + "-fx-border-color: #118C42;" + "-fx-background-color: #75D79C;");
        // vboxleftmenu.setStyle("border-width: medium;");
        // vboxleftmenu.setStyle("-fx-background-radius: 6px, 0px;");
        //vboxleftmenu.setStyle("Border.EMPTY");

        vboxleftmenu.getChildren().add(btnStart);
        vboxleftmenu.getChildren().add(btnLoad);
        vboxleftmenu.getChildren().add(btnSave);
        vboxleftmenu.getChildren().add(btnhint);
        vboxleftmenu.getChildren().add(btnCheck);
        vboxleftmenu.getChildren().add(btnGiveUp);
        vboxleftmenu.getChildren().add(Clear);

        vboxleftmenu.getChildren().add(btnExit);

        GridPane gameGrid = new GridPane();
        borderpane = new BorderPane();

        borderpane.setLeft(vboxleftmenu);
        borderpane.setTop(hboxtopmenu);

        btnStart.setOnAction((ActionEvent ActionEvent) -> {
            System.out.println("Game commencing in 3,2,1...");

            try {

                Thread.sleep(3000);

            } catch (InterruptedException ex) {

                // do nothing
            }
            ActualPuzzle.fillPuzzle(5, 5, 5);
            Pane NewGame = NewGame(ActualPuzzle);
            borderpane.setCenter(NewGame(ActualPuzzle));
        });

        Scene scene;
        scene = new Scene(borderpane);
        primaryStage.setTitle("Futoshiki Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest((WindowEvent actionEvent) -> {
            Platform.exit();
        });

    }

    public void checkGamesSaved() throws FileNotFoundException {
        File directory = new File("data");
        //handling game file
        if (directory.exists()) {
            String[] files = directory.list();
            System.out.println(files.length + " Game has been found:  ");
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("There are no previous games saved in this folder.");
        }
    }

    public void saveGame() {
        Futoshiki ActualPuzzle;
        ActualPuzzle = new Futoshiki();

        try {
            FileWriter file = new FileWriter("savedGame.txt");

            try (BufferedWriter buffer = new BufferedWriter(file)) {
                //buffer.write(ActualPuzzle.displayString());
                buffer.write(ActualPuzzle.displayString());
            }
        } catch (IOException e) {
            System.out.println("Error has occured with saving, please try again please!");
        }

    }

    public void setTile(ButtonClass tile) {
        this.tile = tile;
    }

//    public void tileButtons(){
//        FutoshikiSquare Square;
//        Button button = new Button();
//        
//    Square = new FutoshikiSquare();
//        if (Square.getValue() < ActualPuzzle.gridSize) {
//            Square.setValue(Square.getValue() +1);
//            button.setText(Integer.toString(Square.getValue()));
////            ActualPuzzle.setSquare(grid, grid, grid);
//        } else {
//        }
//    
//    }
    public Pane NewGame(Futoshiki futo) {
        tile = null;
        Futoshiki ActualPuzzle = futo;
        GridPane gameGrid = new GridPane();

        for (int i = 0; i < ActualPuzzle.gridSize; i++) {
            for (int j = 0; j < ActualPuzzle.gridSize; j++) {
                ButtonClass tile;
                tile = new ButtonClass(Integer.toString(ActualPuzzle.getSquare(j, i).getValue()), ActualPuzzle, ActualPuzzle.getSquare(j, i));

                gameGrid.add(tile, i * 2, j * 2);

            }
        }
        for (int i = 0; i < ActualPuzzle.gridSize - 1; i++) {
            for (int j = 0; j < ActualPuzzle.gridSize - 1; j++) {
                Label letter;
                letter = new Label(ActualPuzzle.getRow(i, j).getSymbol());
                letter.setAlignment(Pos.CENTER);
                gameGrid.add(letter, i * 2 + 1, j * 2);

            }

        }

        for (int i = 0; i < ActualPuzzle.gridSize - 1; i++) {
            for (int j = 0; j < ActualPuzzle.gridSize - 1; j++) {
                Label letter;
                letter = new Label(ActualPuzzle.getColumn(i, j).getSymbol());
                letter.setAlignment(Pos.CENTER);
                gameGrid.add(letter, i * 2, j * 2 + 1);
                GridPane.setHalignment(letter, HPos.CENTER);

            }

        }

        //      if (tile. == 0) {
        // }
        return gameGrid;
    }

    public boolean gameSolver() {
        if (ActualPuzzle.isPuzzleSolved() == true && ActualPuzzle.isLegal() && ActualPuzzle.empty(grid, grid) == false) {
            return true;
        } else {
            return false;
        }

//        for (int i = 0; i < ; i++) {
//            for (int j = 0; j < arr.length; j++) {
//               
//                
//            }
//        }
    }

    /**
     * @param args the command line arguments
     *
     * public static void main(String[] args) { launch(args); }
     */
}
