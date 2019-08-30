package main.checkers.board.pawns;

public class Pawn implements Figure {
    private FigureColor color;
    @Override
    public FigureColor getColor() {
        return color;
    }
    public Pawn(FigureColor color) {
        this.color = color;
    }
}
