package main.checkers.board;

public class Coordinates {
    private final int x1;
    private final int y1;

    public Coordinates(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public static Coordinates of(int x1, int y1) {
        return new Coordinates(x1, y1);
    }
}
