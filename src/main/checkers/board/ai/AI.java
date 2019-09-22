package main.checkers.board.ai;

import main.checkers.board.Board;
import main.checkers.board.Coordinates;
import main.checkers.board.Move;
import main.checkers.board.pawns.FigureColor;

import java.util.ArrayList;
import java.util.List;

public class AI {
    public static Move selectBestMove(Board board){
        List <Move> possibleMoves = new ArrayList<Move>();

        for (int row = 0; row < board.getRows().size(); row++) {
            for (int col = 0; col < board.getRows().get(row).getCols().size(); col ++){
                if (board.getRows().get(row).getCols().get(col).getColor().equals(FigureColor.BLACK)) {
                    List <Move> possibleBlackFigureMoves = getPossibleMoves(board, row, col);
                    possibleMoves.addAll(possibleBlackFigureMoves);

                    //Here I should call a method which will gather all possible moves for this particular figure. This moves should be added to possible moves collection.
                    //This is Part number 1 of mine job.

                    //When you will have collection of moves, I have to calculate score for every of this moves. I will need to make board copy
                    // (of Board object within memory) and on this copy i have to make a particular move and after the move calculate the score.

                    //When I will calculate score i Have to remember the score with move. Hashmap...

                    //At the very end i wil have map, and I have to select move of the best score. It should be returned from this method.

                    //If black turns begin i have to calll AI method to determine which method should be done. I should do this move acting as a computer.
                }
            }
        }

        return null;
    }

    private static List<Move> getPossibleMoves(Board board, int row, int col) {
      return null;
    }
}
