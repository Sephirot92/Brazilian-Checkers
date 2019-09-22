package main.checkers.board;

public class Move {
    private Coordinates whereMoveBeginsFrom;
    private Coordinates whereMoveIsBeginMade;

    public Move(Coordinates whereMoveBeginsFrom, Coordinates whereMoveisBeginMade) {
        this.whereMoveBeginsFrom = whereMoveBeginsFrom;
        this.whereMoveIsBeginMade = whereMoveisBeginMade;
    }

    public Coordinates getWhereMoveBeginsFrom() {
        return whereMoveBeginsFrom;
    }

    public Coordinates getWhereMoveIsBeginMade() {
        return whereMoveIsBeginMade;
    }
}
