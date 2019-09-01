package main.checkers.board;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import main.checkers.board.pawns.Figure;
import main.checkers.board.pawns.FigureColor;
import main.checkers.board.pawns.None;
import main.checkers.board.pawns.Pawn;
import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.SwingConstants.CENTER;
import static sun.plugin.javascript.navig.JSType.Image;

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
    public void displayOnGrid(GridPane gridPane){
        initBoard();
        gridPane.getChildren().clear();
        for(int i = 0; i<8; i++) { //iterate over rows
            for (int j = 0; j < 8; j++) {
                    Circle c = null;
                    if (getFigure(j,i) instanceof Pawn){
                        if (getFigure(j,i).getColor().equals(FigureColor.RED)){

                            c = new Circle(20,20,20, Color.rgb(100,0,0));
                            gridPane.add(c, j ,i);
                            gridPane.setPadding(new Insets(50,0,50,50));
                            gridPane.setHgap(0);
                            gridPane.setVgap(0);
                            gridPane.setAlignment(Pos.CENTER);
                            gridPane.setValignment(gridPane, VPos.CENTER);
                        }else{
                            c = new Circle(20, 20, 20, Color.rgb(0,0, 0));
                            gridPane.add(c, j ,i);
                            gridPane.setPadding(new Insets(50,0,50,50));
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
}
