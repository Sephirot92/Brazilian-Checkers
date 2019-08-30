package main.checkers.game;

import javafx.scene.layout.GridPane;
import main.checkers.board.Board;

public class Game {
    private Board board;
    private GridPane gridPane;

    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
    }

}
