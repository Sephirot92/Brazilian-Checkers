package main.checkers.board.ai;

import main.checkers.board.Board;
import main.checkers.board.Move;
import main.checkers.board.pawns.FigureColor;
import main.checkers.board.pawns.None;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static main.checkers.board.Coordinates.of;

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

        Map<Move, Score> scoring = new HashMap<>();
        for (Move move : possibleMoves) {
            Board underTest = board.deepCopy();

            underTest.move(move.getWhereMoveBeginsFrom(), move.getWhereMoveIsBeginMade());

            Score score = boardScoreCalculator.calculateScore(underTest.getRows());

            scoring.put(move, score);
        }

        //READ ABOUT DEEP COPY ALSO YOU HAVE TO RETURN THIS MOVe, WHICH HAS THE BIGGEST SCORING AFTER ITERATING OVER WHOLE MAP.

        return null;
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
        if (board.getFigure(i, row - 2) instanceof None && board.getFigure(i2, row - 1).getColor().equals(FigureColor.RED)) {
            moves.add(new Move(of(col, row), of(i, row - 2), true));
        }
    }

    private static void registerMoveIfPossible(Board board, int row, int col, ArrayList<Move> moves, int i) {
        if (board.getFigure(i, row - 1) instanceof None)
            moves.add(new Move(of(col, row), of(i, row - 1), false));
    }
}
