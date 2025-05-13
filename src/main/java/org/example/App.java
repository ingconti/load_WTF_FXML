package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;



/*
*
* comes form JAVA non modular using FXML
* added other methods to call from timer
*
*/


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));

        addLabelByCode();

        stage.setScene(scene);

        // if needed... full screen zoom.
        // stage.setMaximized(true);

        stage.setHeight(500);
        stage.setWidth(500);

        stage.show();
    }

    static void setRoot(String fxml) throws IOException {

        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        URL url = App.class.getResource(fxml + ".fxml");
        // eventually check for NON NULL url. (check path/name/folder/package)
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        return fxmlLoader.load();
    }


    private void addLabelByCode(){
        // manually add label:
        Label label = new Label("Ing SW 2025");
        VBox root = (VBox) scene.getRoot();
        root.getChildren().add(label);

    }

    static void loadWTFOnTimer() {
        TimerTask task = new TimerTask() {

            public void run() {

                Platform.runLater(() -> {
                    try {
                        System.out.println("loading..");
                        setRoot("wtf");

                    } catch (Exception  e) {
                        //System.out.println(e);
                    }
                });
            }
        };


        Timer timer = new Timer("Timer");
        long delay = 3000L;
        timer.schedule(task, delay);
    }


    public static void main(String[] args) {
        loadWTFOnTimer();
        launch();
    }

}