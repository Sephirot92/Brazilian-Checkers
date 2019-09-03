package main.checkers.game;

import javafx.scene.layout.GridPane;
import main.checkers.board.Board;

public class Game {
    private Board board;
    private GridPane gridPane;
    private int oldX = -1;
    private int oldY = -1;

    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
    }

    public void playGame() {
        board.initBoard();
        board.displayOnGrid(gridPane);
    }

    public void move(int x, int y) {
        if (oldX == -1) {
            oldX = x;
            oldY = y;
        } else {
            board.move(oldX, oldY, x, y);
            board.displayOnGrid(gridPane);
            oldX = -1;
            oldY = -1;
        }
    }
}
