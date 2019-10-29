package checkers.board;

import checkers.board.pawns.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Board {


    protected List<BoardRow> rows = new ArrayList<>();
    protected FigureColor lastColor = FigureColor.BLACK;

    public Board() {
        for (int i = 0; i < 8; i++)
            rows.add(new BoardRow());
    }

    public Figure getFigure(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().add(col, figure);
        rows.get(row).getCols().remove(col + 1);
    }

    public void initBoard() {
        setFigure(0, 0, new Pawn(FigureColor.RED));
        setFigure(0, 2, new Pawn(FigureColor.RED));
        setFigure(1, 1, new Pawn(FigureColor.RED));
        setFigure(2, 0, new Pawn(FigureColor.RED));
        setFigure(2, 2, new Pawn(FigureColor.RED));
        setFigure(3, 1, new Pawn(FigureColor.RED));
        setFigure(4, 0, new Pawn(FigureColor.RED));
        setFigure(4, 2, new Pawn(FigureColor.RED));
        setFigure(5, 1, new Pawn(FigureColor.RED));
        setFigure(6, 0, new Pawn(FigureColor.RED));
        setFigure(6, 2, new Pawn(FigureColor.RED));
        setFigure(7, 1, new Pawn(FigureColor.RED));

        setFigure(0, 6, new Pawn(FigureColor.BLACK));
        setFigure(1, 5, new Pawn(FigureColor.BLACK));
        setFigure(1, 7, new Pawn(FigureColor.BLACK));
        setFigure(2, 6, new Pawn(FigureColor.BLACK));
        setFigure(3, 5, new Pawn(FigureColor.BLACK));
        setFigure(3, 7, new Pawn(FigureColor.BLACK));
        setFigure(4, 6, new Pawn(FigureColor.BLACK));
        setFigure(5, 5, new Pawn(FigureColor.BLACK));
        setFigure(5, 7, new Pawn(FigureColor.BLACK));
        setFigure(6, 6, new Pawn(FigureColor.BLACK));
        setFigure(7, 5, new Pawn(FigureColor.BLACK));
        setFigure(7, 7, new Pawn(FigureColor.BLACK));
    }

    public void displayOnGrid(GridPane gridPane) {

        gridPane.getChildren().clear();
        for (int i = 0; i < 8; i++) { //iterate over rows
            for (int j = 0; j < 8; j++) {
                Pawn pawn = new Pawn(getFigure(j, i).getColor());
                if (getFigure(j, i) instanceof Pawn) {
                    if (getFigure(j, i).getColor().equals(FigureColor.RED)) {
                        gridPane.add(pawn.getImage(getFigure(j, i).getColor()), j, i);
                        gridPane.setPadding(new Insets(25, 0, 25, 10));
                        gridPane.setHgap(0);
                        gridPane.setVgap(0);
                        gridPane.setAlignment(Pos.CENTER);
                        GridPane.setValignment(gridPane, VPos.CENTER);
                    } else {
                        gridPane.add(pawn.getImage(getFigure(j, i).getColor()), j, i);
                        gridPane.setPadding(new Insets(25, 0, 25, 10));
                        gridPane.setHgap(0);
                        gridPane.setVgap(0);
                        gridPane.setAlignment(Pos.CENTER);
                        GridPane.setValignment(gridPane, VPos.CENTER);
                    }
                }
            }
        }
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        gridPane.setAlignment(Pos.CENTER);
    }

    public void move(Coordinates beginingCoordinates, Coordinates finalCoordinates) {
        FigureColor color = getFigure(beginingCoordinates.getX1(), beginingCoordinates.getY1()).getColor();
        FigureColor isThereAFigureColor = getFigure(finalCoordinates.getX1(), finalCoordinates.getY1()).getColor();
        if (isRedOrBlackChoosen(color) && (color != lastColor)) {
            if (isThereAnotherFigure(finalCoordinates.getX1(), finalCoordinates.getY1(), isThereAFigureColor)) {
                if (isMoveDiagonalOneField(new Coordinates(beginingCoordinates.getX1(), beginingCoordinates.getY1()), new Coordinates(finalCoordinates.getX1(), finalCoordinates.getY1()), color)) {
                    doMove(new Coordinates(beginingCoordinates.getX1(), beginingCoordinates.getY1()), new Coordinates(finalCoordinates.getX1(), finalCoordinates.getY1()));
                    lastColor = color;
                } else {
                    int dy = (finalCoordinates.getY1() > beginingCoordinates.getY1()) ? 1 : -1;
                    int dx = (finalCoordinates.getX1() > beginingCoordinates.getX1()) ? 1 : -1;
                    FigureColor colorOfFigureToBeKilled = getFigure(finalCoordinates.getX1() - dx, finalCoordinates.getY1() - dy).getColor();
                    if (color != colorOfFigureToBeKilled) {
                        doKill(new Coordinates(beginingCoordinates.getX1(), beginingCoordinates.getY1()), new Coordinates(finalCoordinates.getX1(), finalCoordinates.getY1()));
                        lastColor = color;
                    }
                }
            }
        }
    }

    private boolean isMoveDiagonalOneField(Coordinates begginingCoordinates, Coordinates finalCoordinatesAfterMove, FigureColor color) {
        return (color == FigureColor.BLACK && begginingCoordinates.getY1() - finalCoordinatesAfterMove.getY1() == 1 && Math.abs(finalCoordinatesAfterMove.getX1() - begginingCoordinates.getX1()) == 1) || (color == FigureColor.RED && finalCoordinatesAfterMove.getY1() - begginingCoordinates.getY1() == 1 && Math.abs(finalCoordinatesAfterMove.getX1() - begginingCoordinates.getX1()) == 1);
    }

    private boolean isRedOrBlackChoosen(FigureColor color) {
        return color == FigureColor.RED || color == FigureColor.BLACK;
    }

    private boolean isThereAnotherFigure(int x2, int y2, FigureColor isThereAFigureColor) {
        boolean check;
        isThereAFigureColor = getFigure(x2, y2).getColor();
        check = isThereAFigureColor == FigureColor.NONE;
        return check;
    }

    private void doMove(Coordinates moveBeggingCoordinates, Coordinates coordinatesAfterTheMoveIsDone) {

        Figure figure = getFigure(moveBeggingCoordinates.getX1(), moveBeggingCoordinates.getY1());
        setFigure(coordinatesAfterTheMoveIsDone.getX1(), coordinatesAfterTheMoveIsDone.getY1(), figure);
        setFigure(moveBeggingCoordinates.getX1(), moveBeggingCoordinates.getY1(), new None());

//        BoardScoreCalculator calculator = new BoardScoreCalculator();
//        calculator.calculateScore(rows, move.isRedPawnToHit());

    }

    private void doKill(Coordinates coordinatesOfFigureWhichWillKill, Coordinates coordinatesOfFigureWhichWillBeKilled) {
        int dy = (coordinatesOfFigureWhichWillBeKilled.getY1() > coordinatesOfFigureWhichWillKill.getY1()) ? 1 : -1;
        int dx = (coordinatesOfFigureWhichWillBeKilled.getX1() > coordinatesOfFigureWhichWillKill.getX1()) ? 1 : -1;
        Figure figure = getFigure(coordinatesOfFigureWhichWillKill.getX1(), coordinatesOfFigureWhichWillKill.getY1());
        setFigure(coordinatesOfFigureWhichWillBeKilled.getX1(), coordinatesOfFigureWhichWillBeKilled.getY1(), figure);
        setFigure(coordinatesOfFigureWhichWillBeKilled.getX1() - dx, coordinatesOfFigureWhichWillBeKilled.getY1() - dy, new None());
        setFigure(coordinatesOfFigureWhichWillKill.getX1(), coordinatesOfFigureWhichWillKill.getY1(), new None());

    }
    public List<BoardRow> getRows() {
        return rows;
    }

    public Board deepCopy() {
        return new Board(rows, lastColor);
    }

    private Board(List<BoardRow> rows, FigureColor lastColor) {
        List<BoardRow> copiedRows = new ArrayList<>();
        for (BoardRow boardRow : rows) {
            BoardRow newRow = new BoardRow();
            for (Figure figure : boardRow.getCols()) {
                Figure newFigure = getNewFigure(figure);
                newRow.getCols().add(newFigure);
            }
            copiedRows.add(newRow);
        }
        this.rows = copiedRows;
        this.lastColor = lastColor;
    }

    private Figure getNewFigure(Figure figure) {
        if (figure instanceof Pawn)
            return new Pawn(figure.getColor());
        else if (figure instanceof Queen)
            return new Queen(figure.getColor());
        else
            return new None();
    }
}
