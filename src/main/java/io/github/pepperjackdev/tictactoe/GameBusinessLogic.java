package io.github.pepperjackdev.tictactoe;

public class GameBusinessLogic {
    PlaceableEntity entityToPlace;

    public GameBusinessLogic() {
        this.entityToPlace = PlaceableEntity.CROSS;
    }

    public PlaceableEntity getEntityToPlace() {
        PlaceableEntity toReturn = entityToPlace;
        entityToPlace = (entityToPlace == PlaceableEntity.CROSS) ? PlaceableEntity.CIRCLE : PlaceableEntity.CROSS;
        return toReturn;
    }

}
