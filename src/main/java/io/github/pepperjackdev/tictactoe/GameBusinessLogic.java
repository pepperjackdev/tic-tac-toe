package io.github.pepperjackdev.tictactoe;

public class GameBusinessLogic {

    private PlaceableEntity entityToPlace;
    private final static PlaceableEntity DEFAULT_ENTITY_TO_PLACE_AS_FIRST = PlaceableEntity.CROSS;

    public GameBusinessLogic() {
        entityToPlace = DEFAULT_ENTITY_TO_PLACE_AS_FIRST;
    }

    public void loadDefaultToPlaceEntity() {
        entityToPlace = DEFAULT_ENTITY_TO_PLACE_AS_FIRST;
    }

    public PlaceableEntity getEntityToPlace() {
        PlaceableEntity toReturn = entityToPlace;
        entityToPlace = (entityToPlace == PlaceableEntity.CROSS) ? PlaceableEntity.CIRCLE : PlaceableEntity.CROSS;
        return toReturn;
    }

}
