package main.checkers.board.pawns;

public class Queen implements Figure {
    private FigureColor color;
    @Override
    public FigureColor getColor() {
        return color;
    }

    public Queen(FigureColor color) {
        this.color = color;
    }
}
