package checkers.board;

public class Move {
    private Coordinates whereMoveBeginsFrom;
    private Coordinates whereMoveIsBeginMade;
    private boolean isRedPawnToHit;

    public Move(Coordinates whereMoveBeginsFrom, Coordinates whereMoveisBeginMade, boolean isRedPawnToHit) {
        this.whereMoveBeginsFrom = whereMoveBeginsFrom;
        this.whereMoveIsBeginMade = whereMoveisBeginMade;
        this.isRedPawnToHit = isRedPawnToHit;
    }

    public Coordinates getWhereMoveBeginsFrom() {
        return whereMoveBeginsFrom;
    }

    public Coordinates getWhereMoveIsBeginMade() {
        return whereMoveIsBeginMade;
    }

    public boolean isRedPawnToHit() {
        return isRedPawnToHit;
    }
}
