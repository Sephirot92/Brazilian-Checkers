package main.checkers.game;

import javafx.scene.layout.GridPane;
import main.checkers.board.Board;
import main.checkers.board.Coordinates;


public class Game {
    private Board board;
    private GridPane gridPane;
    private Coordinates oldCoordinates;

    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
    }

    public void playGame() {
        board.initBoard();
        board.displayOnGrid(gridPane);
    }

    public void move(Coordinates coordinates) {
        if (oldCoordinates == null) {
            oldCoordinates = coordinates;
        } else {
            board.move(oldCoordinates, coordinates);
            board.displayOnGrid(gridPane);
            oldCoordinates = null;
        }
    }
}
