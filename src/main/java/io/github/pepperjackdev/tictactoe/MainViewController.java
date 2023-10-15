package io.github.pepperjackdev.tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainViewController {

    private double x, y;

    @FXML Pane root;
    @FXML Pane titleBar;
    @FXML StackPane mainFrame;
    @FXML Button closeButton;
    @FXML Button iconizeButton;

    @FXML
    void initialize() throws IOException {

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

        FXMLLoader loader = new FXMLLoader(MainViewController.class.getResource("gameView.fxml"));
        Pane pane = loader.load();

        mainFrame.getChildren().add(pane);

    }

}
