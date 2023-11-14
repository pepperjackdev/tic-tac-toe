package io.github.pepperjackdev.tictactoe;

public class GameBusinessLogic {

    private PlaceableEntity entityToPlace;
    private final static PlaceableEntity DEFAULT_ENTITY_TO_PLACE_AS_FIRST = PlaceableEntity.CROSS;

    public GameBusinessLogic() {
        entityToPlace = DEFAULT_ENTITY_TO_PLACE_AS_FIRST;
    }

    public void loadDefaultEntityToPlace() {
        entityToPlace = DEFAULT_ENTITY_TO_PLACE_AS_FIRST;
    }

    public int[] searchForWinner(PlaceableEntity[] map) {

        // Searching into rows;
        for (int i = 0; i < map.length; i+=3) {
            if (map[i] == map[i+1] && map[i+1] == map[i+2] && map[i] != null) {
                return new int[] {i, i + 1, i + 2};
            }
        }

        // Searching into columns;
        for (int i = 0; i < 3; i+=1) {
            if (map[i] == map[i+3] && map[i+3] == map[i+6] && map[i] != null) {
                return new int[] {i, i + 3, i + 6};
            }
        }

        // Searching diags;
        if (map[0] == map[4] && map[4] == map[8] && map[4] != null) return new int[] {0, 4, 8};
        if (map[2] == map[4] && map[4] == map[6] && map[4] != null) return new int[] {2, 4, 6};

        return null;

    }

    public PlaceableEntity getEntityToPlace() {
        PlaceableEntity toReturn = entityToPlace;
        entityToPlace = (entityToPlace == PlaceableEntity.CROSS) ? PlaceableEntity.CIRCLE : PlaceableEntity.CROSS;
        return toReturn;
    }

}
