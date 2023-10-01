package io.github.pepperjackdev.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class GameViewController {
    List<StackPane> boxes = new ArrayList<>();
    @FXML
    Pane mainPane;
    @FXML
    Pane boxesPane;

    @FXML
    void initialize() {
        boxesPane.getChildren().forEach(n -> {
            if (n instanceof StackPane s) {
                boxes.add(s);
            }
        });

        boxes.forEach(s -> s.setOnMouseClicked(e -> {

        }));
    }
}
