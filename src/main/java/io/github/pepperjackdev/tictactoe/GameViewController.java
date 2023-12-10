package io.github.pepperjackdev.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameViewController {

    /* The BUSINESS-LOGIC-MANAGER */
    private GameBusinessLogic logic;

    /* The boxesPane: this pane contains a 3x3 grid of 9 boxes. */
    @FXML
    Pane boxesPane;

    private List<StackPane> boxes;

    /* The Game-Map */
    private PlaceableEntity[] map;

    /* Winner displayed */
    boolean isWinnerDisplayed = false;

    @FXML void initialize() {

        boxes = new ArrayList<>();
        map = new PlaceableEntity[9];

        /* Initializing the "logic" object. */
        this.logic = new GameBusinessLogic();

        /* Initializing the @boxes list with all the boxes into the boxesPane. */
        boxesPane.getChildren().forEach(n -> {
            if (n instanceof StackPane s) { // The StackPanes present into the boxesPane are all game-boxes, so...
                boxes.add(s); // ...let's add them to the boxes list.
            }
        });

        /* Initializing the behavior of all the nine game-boxes when clicked. */
        boxes.forEach(s -> s.setOnMouseClicked(e -> {
            int index = boxes.indexOf(s);
            place(index);
        }));

    }

    private void place(int index) { // Where I have to put the new entity? (-> Index).

        if (map[index] == null && !isWinnerDisplayed) {
            PlaceableEntity entityToPlace = logic.getEntityToPlace();
            map[index] = entityToPlace;

            int[] winnerIndexes;
            if ((winnerIndexes = logic.searchForWinner(map)) != null) {
                isWinnerDisplayed = true;
                Arrays.fill(map, null);
                for (int i : winnerIndexes) {
                    map[i] = entityToPlace;
                }
            }

            loadMapToBoxesPane();
        }

    }

    @FXML
    private void clean() {
        isWinnerDisplayed = false;
        Arrays.fill(map, null);
        logic.loadDefaultEntityToPlace();
        loadMapToBoxesPane();
    }

    private void loadMapToBoxesPane() {
        for (int i = 0; i < 9; i++) {
            ImageView view = (ImageView) boxes.get(i).getChildren().get(0); // Taking from each box the internal ImageView (located at pos. 0 as child).
            if (map[i] != null) {
                view.setImage(map[i].getImage());
            } else {
                view.setImage(null);
            }
        }
    }

}
