package main.checkers.board.pawns;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen implements Figure {
    private FigureColor color;
    @Override
    public FigureColor getColor() {
        return color;
    }

    public Queen(FigureColor color) {
        this.color = color;
    }
    @Override
    public ImageView getImage(FigureColor color) {
        ImageView queenImage = null;
        if(color == FigureColor.RED){
            Image redQueen = new Image("RedCheckersQueen.jpg");
            ImageView redQ = new ImageView(redQueen);
            queenImage = redQ;
            return queenImage;
        }else {
            Image blackQueen = new Image("BlackCheckersQueen.jpg");
            ImageView blackQ = new ImageView(blackQueen);
            queenImage = blackQ;
            return queenImage;
        }
    }
}
