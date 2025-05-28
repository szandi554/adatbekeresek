/*
* File: App.java
* Author: Siegenthaler Alexandra
* Copyright: 2025, Siegenthaler Alexandra 
* Group: Szoft I-2-E
* Date: 2025-05-26
* Github: https://github.com/szandi554/
* Licenc: MIT
*/


package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Stage _stage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainScene"), 640, 480);
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

    public static void main(String[] args) {
        launch();
    }

}