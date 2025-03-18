package com.brh.aufbauprojekt.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField profileNameTF;
    @FXML
    private TextField ageTF;
    @FXML
    private TextField sizeTF;
    @FXML
    private RadioButton maleToggle;
    @FXML
    private RadioButton femaleToggle;
    @FXML
    private RadioButton diverseToggle;
    @FXML
    private TextField logName;
    @FXML
    private TextField logPW;
    @FXML
    private TextField weightTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField cpasswordTF;

    @FXML
    protected void onConfirmButtonClick() {
        String name = logName.getText();
        String pw = logPW.getText();
        boolean allLoginChecks = true;
//        showInfoWindow("Info","Es sind noch keine Daten gespeichert im Log");
        if ( name.isEmpty() ) {
            showErrorWindow("Error", "Du hast keinen Profilnamen angegeben!");
            allLoginChecks = false;
        }
        else if ( pw.isEmpty() ) {
            showErrorWindow("Error", "Du hast kein Passwort eingegeben!");
            allLoginChecks = false;
        }
        if ( allLoginChecks ) {
            new confirmLogin();

        }
    }
    @FXML
    protected void onNewProfileButtonClick() {

        try {
            App.changeSceneToNewProfile("newProfile.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    public void showInfoWindow(String title, String message){
//        Alert window = new Alert(Alert.AlertType.INFORMATION);
//        showWindow(title, message, window);
//    }
    public void showErrorWindow(String title, String message){
        Alert window = new Alert(Alert.AlertType.ERROR);
        showWindow(title, message, window);
    }
    public void showWindow(String title, String message, Alert window){
        window.setTitle(title);
        window.setHeaderText(null);
        window.setContentText( message );
        window.showAndWait();
    }

    @FXML
    protected void onNewProfileConfirmClick() {
        String profileName = profileNameTF.getText();
        boolean male = maleToggle.isSelected();
        boolean female = femaleToggle.isSelected();
        boolean diverse = diverseToggle.isSelected();
        String page = ageTF.getText();
        String psize = sizeTF.getText();
        String pweight = weightTF.getText();
        String ppassword = passwordTF.getText();
        String pcpassword = cpasswordTF.getText();

        boolean allNewProfileChecks = true;
        if (profileName.isEmpty()) {
            showErrorWindow("Error", "Du hast keinen Profilnamen angegeben!");
            allNewProfileChecks = false;
        }

        else if (ppassword.isEmpty()) {
            showErrorWindow("Error", "Du hast kein Passwort eingegeben!");
            allNewProfileChecks = false;
        }

        else if (pcpassword.isEmpty()) {
            showErrorWindow("Error", "Du musst dein Passwort bestätigen!");
            allNewProfileChecks = false;
        }

        try {
            int age = Integer.parseInt(page);
            if (age <= 0 || age > 120) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
            showErrorWindow("Error", "Dein Alter ist ungültig");
            allNewProfileChecks = false;
        }

        try {
            int size = Integer.parseInt(psize);
            if (size < 50 || size > 250) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
            showErrorWindow("Error", "Deine größe ist ungültig");
            allNewProfileChecks = false;
        }

        try {
            int weight = Integer.parseInt(pweight);
            if (weight < 10 || weight > 450) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
            showErrorWindow("Error", "Dein Gewicht ist ungültig");
            allNewProfileChecks = false;
        }

        if ( !male && !female && !diverse ) {
            showErrorWindow("Error", "Du musst dein Geschlecht angeben!");
            allNewProfileChecks = false;
        }

    if (allNewProfileChecks) {
        new newProfileModel( profileName, page, psize, pweight, maleToggle, femaleToggle, diverseToggle );
        new newProfile();
    }

    }

    @FXML
    protected void onBackToLoginClick() {
        try {
            App.changeSceneTologin("login.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }