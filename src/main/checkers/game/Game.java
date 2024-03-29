package checkers.game;

import checkers.board.Board;
import checkers.board.Coordinates;
import checkers.board.Move;
import checkers.board.ai.AI;
import javafx.scene.layout.GridPane;


public class Game {
    private Board board;
    private GridPane gridPane;
    private Coordinates oldCoordinates;
    private boolean modeAI = true;

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
            if (modeAI) {
                Move bestAIMove = AI.selectBestMove(board);
                board.move(bestAIMove.getWhereMoveBeginsFrom(), bestAIMove.getWhereMoveIsBeginMade());
            }
            board.displayOnGrid(gridPane);
            oldCoordinates = null;
        }
    }
}
