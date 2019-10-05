package checkers.board.ai;

import checkers.board.BoardRow;
import checkers.board.pawns.FigureColor;

import java.util.List;

public class BoardScoreCalculator {
    public Score calculateScore(List<BoardRow> rows) {
        Score actualScore = scoreCalculatedByNumberOfPawnsLeft(rows);
        outprintOfTheScore(rows);
        return actualScore;
    }

    public Score scoreCalculatedByNumberOfPawnsLeft(List<BoardRow> rows) {
        int scoreAtTheBegginignForRed = 0;
        int scoreAtTheBegginingForBlack = 0;

        for (int row = 0; row < rows.size(); row++) {
            for (int col = 0; col < rows.get(row).getCols().size(); col ++){
                if (rows.get(row).getCols().get(col).getColor().equals(FigureColor.RED)) {
                    scoreAtTheBegginignForRed = scoreAtTheBegginignForRed + row + 1;
                } else if (rows.get(row).getCols().get(col).getColor().equals(FigureColor.BLACK)) {
                    scoreAtTheBegginingForBlack = scoreAtTheBegginingForBlack + 8 - row;
                }
            }
        }
        Score scoreByNumberOfPawnsLeft = new Score(scoreAtTheBegginignForRed, scoreAtTheBegginingForBlack);
        return scoreByNumberOfPawnsLeft;
    }


    public void outprintOfTheScore(List<BoardRow> rows){
        System.out.println(scoreCalculatedByNumberOfPawnsLeft(rows));
    }
}

