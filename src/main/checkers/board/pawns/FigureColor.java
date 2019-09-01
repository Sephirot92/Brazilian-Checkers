package main.checkers.board.pawns;

public enum FigureColor {
    RED (-1),
    BLACK(1),
    NONE (0);

    final int moveDirection;

    FigureColor(int moveDirection){
        this.moveDirection = moveDirection;
    }
}
