package com.brh.aufbauprojekt.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        App.stage = stage;
        Scene scene = new Scene(fxmlLoader.load(), 420, 330);
        stage.setTitle("Welcome to Gymtime Juggler");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeSceneToNewProfile(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(App.class.getResource(fxml));
        stage.setTitle("Gymtime Juggler");
        stage.getScene().setRoot(pane);
    }

    public static void changeSceneTologin(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(App.class.getResource(fxml));
        stage.setTitle("Welcome to Gymtime Juggler");
        stage.getScene().setRoot(pane);
    }

    public static void changeSceneToMainMenu(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(App.class.getResource(fxml));
        stage.setTitle("Main Menu");
        stage.getScene().setRoot(pane);
        stage.setMaximized(true); // fullscreen mode
    }

    public static void main(String[] args) {
        launch(App.class, args);
    }
}