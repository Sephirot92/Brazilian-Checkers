package main.BrazilianCheckers;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BrazilianCheckers extends Application{

    private Image imageback = new Image("CheckersBoard2.jpg");
    private Image redChecker = new Image("RedCheckers.jpg");
    private FlowPane checkersRed = new FlowPane(Orientation.HORIZONTAL);

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(200, 200, true,true, true,false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(1, 1, 1, 1));
        grid.setHgap(4);
        grid.setVgap(4);
        grid.setBackground(background);

        ImageView img = new ImageView(redChecker);
        checkersRed.getChildren().add(img);

        grid.add(checkersRed, 2, 0, 3, 1);

        Scene scene = new Scene (grid, 900, 900, Color.BLACK);

        primaryStage.setTitle("BrazilianCheckers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
