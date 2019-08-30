package main.checkers;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.checkers.board.Board;
import main.checkers.game.Game;

import javax.swing.*;
import java.awt.*;

public class BrazilianCheckers extends Application{

    private Image imageback = new Image("CheckersBoard2.jpg");
//    private Image redChecker = new Image("RedCheckers.jpg");


    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(200, 200, true,true, true,false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();

        grid.setPadding(new Insets(1, 1, 1, 1));
        grid.setHgap(4);
        grid.setVgap(4);
        grid.setBackground(background);

//        ImageView img = new ImageView(redChecker);
//        checkersRed.getChildren().add(img);

//        grid.add(checkersRed, 2, 0, 3, 1);

        Scene scene = new Scene (grid, 900, 900, Color.BLACK);

        Game game = new Game(new Board(), grid); //Inside class (this one!! ) you have acces to board class (With all pawns and game logic) and Grid, where
        // you will be able to display figures form the board


        primaryStage.setTitle("Brazilian Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
//Fill the board with none figures. None and pawn and Queen should drive from common class called figure. board should have Collection - make a new class representing a rows
