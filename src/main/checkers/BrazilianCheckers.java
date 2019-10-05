package checkers;

import checkers.board.Board;
import checkers.board.Coordinates;
import checkers.game.Game;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javax.swing.SwingConstants.CENTER;

public class BrazilianCheckers extends Application {

    private Image imageback = new Image("CheckersBoard2.jpg");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(800, 800, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);

        Game game = new Game(new Board(), grid);
        grid.setOnMouseClicked(e -> {
            int x = (int) (e.getX() / 100);
            int y = (int) (e.getY() / 100);
            System.out.println(x + " " + y);
            game.move(new Coordinates(x, y));
        });


        for (int i = 0; i < 8; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(100));
        }
        for (int i = 0; i < 8; i++) {
            grid.getRowConstraints().add(new RowConstraints(100));
        }
        Scene scene = new Scene(grid, 800, 800, Color.BLACK);

        grid.setPadding(new Insets(CENTER, CENTER, CENTER, CENTER));
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setAlignment(Pos.CENTER);

        game.playGame();

        primaryStage.setTitle("Brazilian Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

