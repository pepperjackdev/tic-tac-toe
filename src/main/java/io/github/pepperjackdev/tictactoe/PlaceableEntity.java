package io.github.pepperjackdev.tictactoe;

import javafx.scene.image.Image;

import java.util.Objects;

public enum PlaceableEntity {
    CROSS("assets/cross.png"),
    CIRCLE("assets/circle.png");

    private final Image image;

    PlaceableEntity(String path) {
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }

    public Image getImage() {
        return this.image;
    }

}
