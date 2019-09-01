package main.checkers;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import main.checkers.board.Board;
import main.checkers.board.pawns.Figure;
import main.checkers.game.Game;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class BrazilianCheckers extends Application{

    private Image imageback = new Image("CheckersBoard2.jpg");

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(800, 800, true,true, true,false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(50,50,50,50));
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);


        for (int i = 0; i < 8; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(100));
        }
        for (int i = 0; i < 8; i++) {
            grid.getRowConstraints().add(new RowConstraints(100));
        }
        Scene scene = new Scene (grid, 800, 800, Color.BLACK);

        grid.setPadding(new Insets(CENTER, CENTER, CENTER, CENTER));
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setAlignment(Pos.CENTER);

        Game game = new Game(new Board(), grid);
        game.playGame();
        //Inside class (this one!! ) you have acces to board class (With all pawns and game logic) and Grid, where
        // you will be able to display figures form the board

        primaryStage.setTitle("Brazilian Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
//Fill the board with none figures. None and pawn and Queen should drive from common class called figure. board should have Collection - make a new class representing a rows

