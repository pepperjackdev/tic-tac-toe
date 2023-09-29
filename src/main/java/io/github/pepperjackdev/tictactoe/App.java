package io.github.pepperjackdev.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Tic Tac Toe | Developed by PepperJackDev");
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}