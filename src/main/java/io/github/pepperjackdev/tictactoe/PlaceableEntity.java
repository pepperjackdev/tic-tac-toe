package io.github.pepperjackdev.tictactoe;

public enum PlaceableEntity {

    CROSS("assets/cross.png"),
    CIRCLE("assets/circle.png");

    private final String imagePath;

    PlaceableEntity(String path) {
        this.imagePath = path;
    }

    public String getImagePath() {
        return imagePath;
    }

}
