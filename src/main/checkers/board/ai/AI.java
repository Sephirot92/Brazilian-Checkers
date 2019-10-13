package checkers.board.ai;

import checkers.board.Board;
import checkers.board.Move;
import checkers.board.pawns.FigureColor;
import checkers.board.pawns.None;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static checkers.board.Coordinates.of;

public class AI {
    public static Move selectBestMove(Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        for (int row = 0; row < board.getRows().size(); row++) {
            for (int col = 0; col < board.getRows().get(row).getCols().size(); col++) {
                if (board.getRows().get(row).getCols().get(col).getColor().equals(FigureColor.BLACK)) {
                    List<Move> possibleBlackFigureMoves = getPossibleMoves(board, row, col);
                    possibleMoves.addAll(possibleBlackFigureMoves);
                }
            }
        }
        BoardScoreCalculator boardScoreCalculator = new BoardScoreCalculator();
        //Debug this line to see possible moves (F8) - check are there included hitting moves.
        //If not, you will know that there is an error in  method possible moves.
        //If they are present, you need to check the scoring function and you should check what are the calcuations results for every of those moves.
        //It will give you the knowledge what is going on and where you have to fix what
        // DEBUG AND BREAKPOINTS ARE CRUCIAL. thanks to them you can look into the variables, during frozen program execution.

        Map<Move, Score> scoring = new HashMap<>();
        for (Move move : possibleMoves) {
            Board underTest = board.deepCopy();

            underTest.move(move.getWhereMoveBeginsFrom(), move.getWhereMoveIsBeginMade());

            Score score = boardScoreCalculator.calculateScore(underTest.getRows());

            scoring.put(move, score);
        }
        Move bestMove = null;
        int moveValue = 0;
        for (Map.Entry<Move, Score> bestMoveToBeMade : scoring.entrySet()) {
            if (moveValue < bestMoveToBeMade.getValue().getBlackScore()) {
                moveValue = bestMoveToBeMade.getValue().getBlackScore();
                bestMove = bestMoveToBeMade.getKey();
            }

        }
        System.out.println("The best move is " + bestMove);
        return bestMove;
        //READ ABOUT DEEP COPY ALSO YOU HAVE TO RETURN THIS MOVe, WHICH HAS THE BIGGEST SCORING AFTER ITERATING OVER WHOLE MAP.
    }

    private static List<Move> getPossibleMoves(Board board, int row, int col) {
        ArrayList<Move> moves = new ArrayList<>();

        if (row == 0)
            return moves;

        registerMoveIfPossible(board, row, col, moves, col - 1);
        registerMoveIfPossible(board, row, col, moves, col + 1);

        registerMoveWithHitIfPossible(board, row, col, moves, col - 2, col - 1);
        registerMoveWithHitIfPossible(board, row, col, moves, col + 2, col + 1);
        return moves;
    }

    private static void registerMoveWithHitIfPossible(Board board, int row, int col, ArrayList<Move> moves, int i, int i2) {
        if (row >= 2 && i >= 0 && i2 >= 0 && row <= 7 && i <= 7 && i2 <= 7 && col >= 0 && col <= 7) {
            if (board.getFigure(i, row - 2) instanceof None && board.getFigure(i2, row - 1).getColor().equals(FigureColor.RED)) {
                moves.add(new Move(of(col, row), of(i, row - 2), true));
            }
        }
    }

    private static void registerMoveIfPossible(Board board, int row, int col, ArrayList<Move> moves, int i) {
        if (row >= 2 && i >= 0 && row <= 7 && i <= 7 && col >= 0 && col <= 7) {
            if (board.getFigure(i, row - 1) instanceof None)
                moves.add(new Move(of(col, row), of(i, row - 1), false));
        }
    }
}
