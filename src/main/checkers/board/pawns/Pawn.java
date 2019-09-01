package main.checkers.board.pawns;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn implements Figure {
    private FigureColor color;
    @Override
    public FigureColor getColor() {
        return color;
    }
    public Pawn(FigureColor color) {
        this.color = color;
    }

    @Override
    public ImageView getImage(FigureColor color) {
        ImageView pawnImage = null;
        if(color == FigureColor.RED){
            Image redPawn = new Image("RedCheckers.jpg");
            ImageView redP = new ImageView(redPawn);
            pawnImage = redP;
            return pawnImage;
        }else {
            Image blackPawn = new Image("BlackChecker.jpg");
            ImageView blackP = new ImageView(blackPawn);
            pawnImage = blackP;
            return pawnImage;
        }
    }
}
