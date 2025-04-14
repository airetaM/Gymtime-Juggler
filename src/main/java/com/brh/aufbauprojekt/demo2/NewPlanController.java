package com.brh.aufbauprojekt.demo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.event.ActionEvent;
import java.io.IOException;

public class NewPlanController {
    @FXML
    private Slider slider;

    @FXML
    public void initialize() {
        slider.setMin(1);
        slider.setMax(7);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setValue(3);
        slider.setBlockIncrement(1);
    }

    @FXML
    protected void onConfirmClick(ActionEvent event) throws IOException {
        for (int i = 1; i < 8; i++) {
            if (slider.getValue() == i) {
                TrainingPlanModel.setDaysPerWeek(i);
                break;
            }
        }
        showNewWindow("NewPlanWichDay.fxml");

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
        Node source = (Node) event.getSource();
        Window stage = source.getScene().getWindow();
        stage.hide();
    }
}
