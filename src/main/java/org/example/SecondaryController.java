package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SecondaryController {

    @FXML
    private ImageView imageView;

    @FXML
    private void switchToPrimary()  {
        try {
            App.setRoot("primary");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private void loadStraberry() throws IOException {
        Image img = new Image("strawberry.png");

        this.imageView.setImage(img);
    }



}