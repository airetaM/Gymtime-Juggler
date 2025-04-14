package com.brh.aufbauprojekt.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class WichDayController {
    @FXML
    private TextFlow wichDayTextfield;
    @FXML
    private CheckBox Checkbox1;
    @FXML
    private CheckBox Checkbox2;
    @FXML
    private CheckBox Checkbox3;
    @FXML
    private CheckBox Checkbox4;
    @FXML
    private CheckBox Checkbox5;
    @FXML
    private CheckBox Checkbox6;
    @FXML
    private CheckBox Checkbox7;
    @FXML
    private Button confirmButton;

    @FXML
    public void initialize() {
        for (int i = 0; i < 7; i++) {
            TrainingPlanModel.chosenDays[i] = false;
        }

        String blackText = ("-fx-font-size: 15px; -fx-fill: navy; -fx-font-family: \"Arial\"; -fx-font-weight: bold; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 5, 0.3, 0, 1);");
        String redText = ("-fx-font-size: 15px; -fx-fill: red; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
        if (TrainingPlanModel.getDaysPerWeek() == 1) {
            Text text = new Text("An welchem Tag willst du diese Woche trainieren gehen?");
            text.setStyle(blackText);

            wichDayTextfield.getChildren().clear();
            wichDayTextfield.getChildren().add(text);

        } else if (TrainingPlanModel.getDaysPerWeek() < 4) {
            Text text = new Text("An welchen Tagen willst du diese Woche trainieren gehen?");
            text.setStyle(blackText);

            wichDayTextfield.getChildren().clear();
            wichDayTextfield.getChildren().add(text);

        } else if (TrainingPlanModel.getDaysPerWeek() < 6) {
            Text text1 = new Text("An welchen Tagen willst du diese Woche ");
            text1.setStyle(blackText);

            Text text2 = new Text("nicht");
            text2.setStyle(redText);

            Text text3 = new Text(" trainieren gehen?");
            text3.setStyle(blackText);

            wichDayTextfield.getChildren().clear();
            wichDayTextfield.getChildren().addAll(text1, text2, text3);
        } else if (TrainingPlanModel.getDaysPerWeek() < 7) {
            Text text1 = new Text("An welchem Tag willst du diese Woche ");
            text1.setStyle(blackText);

            Text text2 = new Text("nicht");
            text2.setStyle(redText);

            Text text3 = new Text(" trainieren gehen?");
            text3.setStyle(blackText);

            wichDayTextfield.getChildren().clear();
            wichDayTextfield.getChildren().addAll(text1, text2, text3);
        } else {
            Text text = new Text("Jeden Tag zu trainieren ist keine gute Idee, du solltest dir auch mal eine Pause gönnen!");
            text.setStyle(blackText);

            wichDayTextfield.getChildren().clear();
            wichDayTextfield.getChildren().add(text);

            disableCheckboxes();
        }
    }

    @FXML
    protected void onConfirmClick(ActionEvent event) throws IOException {
        if (TrainingPlanModel.getDaysPerWeek() < 4) {
            if (Checkbox1.isSelected()) {
                TrainingPlanModel.chosenDays[0] = true;
            }
            if (Checkbox2.isSelected()) {
                TrainingPlanModel.chosenDays[1] = true;
            }
            if (Checkbox3.isSelected()) {
                TrainingPlanModel.chosenDays[2] = true;
            }
            if (Checkbox4.isSelected()) {
                TrainingPlanModel.chosenDays[3] = true;
            }
            if (Checkbox5.isSelected()) {
                TrainingPlanModel.chosenDays[4] = true;
            }
            if (Checkbox6.isSelected()) {
                TrainingPlanModel.chosenDays[5] = true;
            }
            if (Checkbox7.isSelected()) {
                TrainingPlanModel.chosenDays[6] = true;
            }
        } else {
            if (Checkbox1.isSelected()) {
                TrainingPlanModel.chosenDays[0] = false;
            } else {
                TrainingPlanModel.chosenDays[0] = true;
            }
            if (Checkbox2.isSelected()) {
                TrainingPlanModel.chosenDays[1] = false;
            } else {
                TrainingPlanModel.chosenDays[1] = true;
            }
            if (Checkbox3.isSelected()) {
                TrainingPlanModel.chosenDays[2] = false;
            } else {
                TrainingPlanModel.chosenDays[2] = true;
            }
            if (Checkbox4.isSelected()) {
                TrainingPlanModel.chosenDays[3] = false;
            } else {
                TrainingPlanModel.chosenDays[3] = true;
            }
            if (Checkbox5.isSelected()) {
                TrainingPlanModel.chosenDays[4] = false;
            } else {
                TrainingPlanModel.chosenDays[4] = true;
            }
            if (Checkbox6.isSelected()) {
                TrainingPlanModel.chosenDays[5] = false;
            } else {
                TrainingPlanModel.chosenDays[5] = true;
            }
            if (Checkbox7.isSelected()) {
                TrainingPlanModel.chosenDays[6] = false;
            } else {
                TrainingPlanModel.chosenDays[6] = true;
            }
        }
        showNewPlanWindow("PlanChooser.fxml");
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
    public static void showNewPlanWindow(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setResizable(true);
        stage.setTitle("Neuer Trainingsplan");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaximized(true);
        stage.showAndWait();
    }

    @FXML
    protected void onBackClick(ActionEvent event) throws IOException {
        showNewWindow("NewPlan.fxml");

        Node source = (Node) event.getSource();
        Window stage = source.getScene().getWindow();
        stage.hide();

        checkboxCount = 0;
    }
    private int checkboxCount;
    @FXML
    protected void onMondayClicked(ActionEvent event) {
        if (Checkbox1.isSelected()) {

            checkboxCount++;
        } else {

            checkboxCount--;
        }
        if (TrainingPlanModel.getDaysPerWeek() < 4) {
            if (checkboxCount == TrainingPlanModel.getDaysPerWeek()) {
                disableCheckboxes();
            }

        } else {
            if (checkboxCount == (7 - TrainingPlanModel.getDaysPerWeek())) {
                disableCheckboxes();
            }
        }
    }

    @FXML
    protected void onTuesdayClicked(ActionEvent event) {
        if (Checkbox2.isSelected()) {

            checkboxCount++;
        } else {

            checkboxCount--;
        }
        if (TrainingPlanModel.getDaysPerWeek() < 4) {
            if (checkboxCount == TrainingPlanModel.getDaysPerWeek()) {
                disableCheckboxes();
            }
        }else {
                if (checkboxCount == (7 - TrainingPlanModel.getDaysPerWeek())) {
                    disableCheckboxes();
                }
            }
    }
    @FXML
    protected void onWednesdayClicked(ActionEvent event) {
        if (Checkbox3.isSelected()) {

            checkboxCount++;
        } else {

            checkboxCount--;
        }
        if (TrainingPlanModel.getDaysPerWeek() < 4){
            if (checkboxCount == TrainingPlanModel.getDaysPerWeek()) {
                disableCheckboxes();
            }
        } else {
                if (checkboxCount == (7 - TrainingPlanModel.getDaysPerWeek())) {
                    disableCheckboxes();
                }
            }
    }
    @FXML
    protected void onThursdayClicked(ActionEvent event) {
        if (Checkbox4.isSelected()) {

            checkboxCount++;
        } else {

            checkboxCount--;
        }
        if (TrainingPlanModel.getDaysPerWeek() < 4) {
            if (checkboxCount == TrainingPlanModel.getDaysPerWeek()) {
                disableCheckboxes();
            }
        } else {
                if (checkboxCount == (7 - TrainingPlanModel.getDaysPerWeek())) {
                    disableCheckboxes();
                }
            }
    }
    @FXML
    protected void onFridayClicked(ActionEvent event) {
        if (Checkbox5.isSelected()) {

            checkboxCount++;
        } else {

            checkboxCount--;
        }
        if (TrainingPlanModel.getDaysPerWeek() < 4){
            if (checkboxCount == TrainingPlanModel.getDaysPerWeek()) {
                disableCheckboxes();
            }
        } else {
                if (checkboxCount == (7 - TrainingPlanModel.getDaysPerWeek())) {
                    disableCheckboxes();
                }
            }

    }
    @FXML
    protected void onSaturdayClicked(ActionEvent event) {
        if (Checkbox6.isSelected()) {

            checkboxCount++;
        } else {

            checkboxCount--;
        }
        if (TrainingPlanModel.getDaysPerWeek() < 4) {
            if (checkboxCount == TrainingPlanModel.getDaysPerWeek()) {
                disableCheckboxes();
            }
        } else {
                if (checkboxCount == (7 - TrainingPlanModel.getDaysPerWeek())) {
                    disableCheckboxes();
                }
            }

    }
    @FXML
    protected void onSundayClicked(ActionEvent event) {
        if (Checkbox7.isSelected()) {

            checkboxCount++;
        } else {

            checkboxCount--;
        }
        if (TrainingPlanModel.getDaysPerWeek() < 4) {
            if (checkboxCount == TrainingPlanModel.getDaysPerWeek()) {
                disableCheckboxes();
            }
        } else {
                if (checkboxCount == (7 - TrainingPlanModel.getDaysPerWeek())) {
                    disableCheckboxes();
                }
            }

    }

    private void disableCheckboxes() {
        Checkbox1.setDisable(true);
        Checkbox2.setDisable(true);
        Checkbox3.setDisable(true);
        Checkbox4.setDisable(true);
        Checkbox5.setDisable(true);
        Checkbox6.setDisable(true);
        Checkbox7.setDisable(true);
        confirmButton.setDisable(false);
        confirmButton.requestFocus();
    }
}
