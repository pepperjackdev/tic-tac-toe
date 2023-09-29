package io.github.pepperjackdev.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameController {

    private double x, y;
    private Pane[][] boxesArray;
    private static final String CROSS_IMAGE_PATH = "assets/cross.png";
    private static final String CIRCLE_IMAGE_PATH = "assets/circle.png";
    private Placeable toPlace = Placeable.CROSS;

    @FXML
    Pane root;

    @FXML
    Pane titleBar;

    @FXML
    Button closeButton;

    @FXML
    Button iconizeButton;

    @FXML
    Pane boxesPane;

    @FXML
    Button resetGame;

    @FXML
    Button settings;

    enum Placeable {
        CROSS, CIRCLE
    }

    @FXML
    void initialize() {

        /* TitleBar */

        titleBar.setOnMousePressed(e -> {
            x = e.getSceneX();
            y = e.getSceneY();
        });

        titleBar.setOnMouseDragged(e -> {
            App.stage.setX(e.getScreenX() - x);
            App.stage.setY(e.getScreenY() - y);
        });

        closeButton.setOnAction(e -> App.stage.close());

        iconizeButton.setOnAction(e -> App.stage.setIconified(true));

        /* Boxes */

        List<StackPane> boxes = new ArrayList<>();

        boxesPane.getChildren().forEach(n -> {
            if (n instanceof StackPane s) {
                boxes.add(s);
            }
        });

        boxes.forEach(s -> s.setOnMouseClicked(e -> {

            if (!s.getChildren().isEmpty()) {
                return;
            }

            ImageView imageView=new ImageView(
                    new Image(Objects.requireNonNull(getClass().getResourceAsStream(getEntityToPlace())))
            );

            imageView.setFitWidth(60);
            imageView.setFitHeight(60);

            s.getChildren().add(
                    imageView
            );
        }));

    }

    private String getEntityToPlace() {
        switch (toPlace) {
            case CROSS -> {
                toPlace = Placeable.CIRCLE;
                return CROSS_IMAGE_PATH;
            }
            case CIRCLE -> {
                toPlace = Placeable.CROSS;
                return CIRCLE_IMAGE_PATH;
            }
            default -> {
                return CROSS_IMAGE_PATH;
            }
        }
    }





}
