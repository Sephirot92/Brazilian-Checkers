package main.checkers.board.pawns;

import javafx.scene.image.ImageView;

public interface Figure {
    FigureColor getColor();
    ImageView getImage(FigureColor color);
}
