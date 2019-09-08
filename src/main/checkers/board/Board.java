package main.checkers.board;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import main.checkers.board.pawns.Figure;
import main.checkers.board.pawns.FigureColor;
import main.checkers.board.pawns.None;
import main.checkers.board.pawns.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();
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
        //SetFigure for Red Pawns
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

        //SetFigure for black Pawns
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
                        gridPane.setValignment(gridPane, VPos.CENTER);
                    } else {
                        gridPane.add(pawn.getImage(getFigure(j, i).getColor()), j, i);
                        gridPane.setPadding(new Insets(25, 0, 25, 10));
                        gridPane.setHgap(0);
                        gridPane.setVgap(0);
                        gridPane.setAlignment(Pos.CENTER);
                        gridPane.setValignment(gridPane, VPos.CENTER);
                    }
                }
            }
        }
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        gridPane.setAlignment(Pos.CENTER);
    }

    public void move(int x1, int y1, int x2, int y2) {
        FigureColor color = getFigure(x1, y1).getColor();

        FigureColor isThereAFigureColor = getFigure(x2, y2).getColor();
        if (isRedOrBlackChoosen(color) && (color != lastColor)) {
            if (isThereAnotherFigure(x1, y1, x2, y2, isThereAFigureColor)) {
                if (isMoveDiagonalOneField(x1, y1, x2, y2, color)) {
                    doMove(x1, y1, x2, y2);
                    lastColor = color;
                } else {
                    int dy = (y2 > y1) ? 1 : -1;
                    int dx = (x2 > x1) ? 1 : -1;
                    FigureColor colorOfFigureToBeKilled = getFigure(x2 - dx, y2 - dy).getColor();
                    if (color != colorOfFigureToBeKilled) {
                        doKill(x1, y1, x2, y2);
                        lastColor = color;
                    }
                }
            }
        }
    }


    private boolean isMoveDiagonalOneField(int x1, int y1, int x2, int y2, FigureColor color) {
        return (color == FigureColor.BLACK && y1 - y2 == 1 && Math.abs(x2 - x1) == 1) || (color == FigureColor.RED && y2 - y1 == 1 && Math.abs(x2 - x1) == 1);
    }

    private boolean isRedOrBlackChoosen(FigureColor color) {
        return color == FigureColor.RED || color == FigureColor.BLACK;
    }

    private boolean isThereAnotherFigure(int x1, int y1, int x2, int y2, FigureColor isThereAFigureColor) {
        boolean check;
        isThereAFigureColor = getFigure(x2, y2).getColor();
        if (isThereAFigureColor == FigureColor.NONE) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    private void doMove(int x1, int y1, int x2, int y2) {

        Figure figure = getFigure(x1, y1);
        setFigure(x2, y2, figure);
        setFigure(x1, y1, new None());

    }

    private void doKill(int x1, int y1, int x2, int y2) {
        int dy = (y2 > y1) ? 1 : -1;
        int dx = (x2 > x1) ? 1 : -1;
        Figure figure = getFigure(x1, y1);
        setFigure(x2, y2, figure);
        setFigure(x2 - dx, y2 - dy, new None());
        setFigure(x1, y1, new None());

    }
}
