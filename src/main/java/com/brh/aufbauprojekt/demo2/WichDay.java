package com.brh.aufbauprojekt.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class WichDay {
    @FXML
    protected void onConfirmClick(ActionEvent event) throws IOException {
//        showNewWindow("NewPlanWichDay.fxml");
        // Close the current stage
        Node source = (Node) event.getSource();
        Window stage = source.getScene().getWindow();
        stage.hide();

    }

    @FXML
    public static void showNewWindow(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Neuer Trainingsplan");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    protected void onBackClick(ActionEvent event) throws IOException {
        showNewWindow("NewPlan.fxml");
        // Close the current stage
        Node source = (Node) event.getSource();
        Window stage = source.getScene().getWindow();
        stage.hide();

    }


}
