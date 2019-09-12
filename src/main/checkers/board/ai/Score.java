package main.checkers.board.ai;

public class Score {
    private int redScore;
    private int blackScore;

    public Score(int redScore, int blackScore) {
        this.redScore = redScore;
        this.blackScore = blackScore;
    }

    public int getRedScore() {
        return redScore;
    }

    public int getBlackScore() {
        return blackScore;
    }
}
