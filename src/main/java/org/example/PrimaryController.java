package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
