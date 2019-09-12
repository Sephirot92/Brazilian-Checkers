package main.checkers.board.ai;

import main.checkers.board.Board;
import main.checkers.board.BoardRow;
import main.checkers.board.pawns.Figure;
import main.checkers.board.pawns.FigureColor;

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

        Score scoreByNumberOfPawnsLeft = new Score(scoreAtTheBegginignForRed, scoreAtTheBegginingForBlack);
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).equals(FigureColor.RED)) {
                scoreAtTheBegginignForRed = scoreAtTheBegginignForRed + 1;
            } else if (rows.get(i).equals(FigureColor.BLACK)) {
                scoreAtTheBegginingForBlack = scoreAtTheBegginingForBlack + 1;
            }
        }
        return scoreByNumberOfPawnsLeft;
    }


    public void outprintOfTheScore(List<BoardRow> rows){
        System.out.println(scoreCalculatedByNumberOfPawnsLeft(rows));
    }
}

//po opracowaniu podepnij do move i zobacz jakie wyniki wyświetli jako syso.
