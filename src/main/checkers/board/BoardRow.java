package main.checkers.board;

import main.checkers.board.pawns.Figure;
import main.checkers.board.pawns.None;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private List<Figure> cols = new ArrayList<>();

    public BoardRow() {
        for (int i = 0; i <8; i ++)
            cols.add(new None());
    }

    public List<Figure> getCols() {
        return cols;
    }
}
