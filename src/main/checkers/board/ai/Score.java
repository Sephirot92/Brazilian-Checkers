package checkers.board.ai;

public class Score {
    private int redScore;
    private int blackScore;
    private boolean isBlackAbleToHit;

    public Score(int redScore, int blackScore, boolean isBlackAbleToHit) {
        this.redScore = redScore;
        this.blackScore = blackScore;
        this.isBlackAbleToHit = isBlackAbleToHit;
    }

    public int getRedScore() {
        return redScore;
    }

    public int getBlackScore() {
        return blackScore;
    }

    public boolean isBlackAbleToHit() {
        return isBlackAbleToHit;
    }

    @Override
    public String toString() {
        return "Score{" +
                "redScore=" + redScore +
                ", blackScore=" + blackScore +
                '}';
    }
}
