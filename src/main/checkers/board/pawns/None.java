package main.checkers.board.pawns;

import javafx.scene.image.ImageView;

public class None implements Figure {
    @Override
    public FigureColor getColor() {
        return FigureColor.NONE;
    }

    @Override
    public ImageView getImage(FigureColor color) {
        ImageView noneImage = null;
        return noneImage;

    }
}
