package main.checkers.board;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import main.checkers.board.pawns.Figure;
import main.checkers.board.pawns.FigureColor;
import main.checkers.board.pawns.None;
import main.checkers.board.pawns.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();

    public Board() {
        for(int i = 0; i <8; i++)
            rows.add(new BoardRow());
    }
    public Figure getFigure(int col, int row){
        return rows.get(row).getCols().get(col);
    }
    public void setFigure (int col, int row, Figure figure){
        rows.get(row).getCols().add(col, figure);
        rows.get(row).getCols().remove(col+1);
    }
    public void initBoard(){
        //SetFigure for Red Pawns
        setFigure(0,0, new Pawn(FigureColor.RED));
        setFigure(0,2, new Pawn(FigureColor.RED));
        setFigure(1,1, new Pawn(FigureColor.RED));
        setFigure(2,0, new Pawn(FigureColor.RED));
        setFigure(2,2, new Pawn(FigureColor.RED));
        setFigure(3,1, new Pawn(FigureColor.RED));
        setFigure(4,0, new Pawn(FigureColor.RED));
        setFigure(4,2, new Pawn(FigureColor.RED));
        setFigure(5,1, new Pawn(FigureColor.RED));
        setFigure(6,0, new Pawn(FigureColor.RED));
        setFigure(6,2, new Pawn(FigureColor.RED));
        setFigure(7,1, new Pawn(FigureColor.RED));

        //SetFigure for black Pawns
        setFigure(0,6, new Pawn(FigureColor.BLACK));
        setFigure(1,5, new Pawn(FigureColor.BLACK));
        setFigure(1,7, new Pawn(FigureColor.BLACK));
        setFigure(2,6, new Pawn(FigureColor.BLACK));
        setFigure(3,5, new Pawn(FigureColor.BLACK));
        setFigure(3,7, new Pawn(FigureColor.BLACK));
        setFigure(4,6, new Pawn(FigureColor.BLACK));
        setFigure(5,5, new Pawn(FigureColor.BLACK));
        setFigure(5,7, new Pawn(FigureColor.BLACK));
        setFigure(6,6, new Pawn(FigureColor.BLACK));
        setFigure(7,5, new Pawn(FigureColor.BLACK));
        setFigure(7,7, new Pawn(FigureColor.BLACK));
    }
    ImageView imageView = null;
    public void displayOnGrid(GridPane gridPane){
        gridPane.getChildren().clear();
        for(int i = 0; i<8; i++) { //iterate over rows
            for (int j = 0; j < 8; j++) { //iterate over columns
                ImageView imageView =  new ImageView(""); //decide what image you will place in here basing on what you will receive from getFigure(col, row);
                gridPane.add(imageView, j, i);
            }
        }
    }
}
