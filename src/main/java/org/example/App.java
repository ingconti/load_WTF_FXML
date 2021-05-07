package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
*
* comes form JAVA non modular using FXML
* added other methods to call from timer
*
* */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



    static void LoadWTFOnTimer() {
        TimerTask task = new TimerTask() {

            public void run() {

                Platform.runLater(() -> {
                    try {
                        System.out.println("loading..");
                        setRoot("wtf");

                    } catch (Exception  ex) {
                        System.out.println(ex);
                    }
                });
            }
        };


        Timer timer = new Timer("Timer");
        long delay = 3000L;
        timer.schedule(task, delay);
    }


    public static void main(String[] args) {

        LoadWTFOnTimer();
        launch();
    }

}