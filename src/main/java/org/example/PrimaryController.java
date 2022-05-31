package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {

        // eventually load  image, too:
        Image img =
                new Image("full_0000s_0000_god_and_hero_cards_0056_scylla.png");


        App.setRoot("AAA/secondary");
    }
}
