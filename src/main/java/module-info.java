module io.github.pepperjackdev.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.pepperjackdev.tictactoe to javafx.fxml;
    exports io.github.pepperjackdev.tictactoe;
}