package com.brh.aufbauprojekt.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField profileNameTF;
    @FXML
    private TextField logName;
    @FXML
    private TextField logPW;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField cpasswordTF;

    @FXML
    protected void onConfirmButtonClick() {
        String name = logName.getText();
        String pw = logPW.getText();
        boolean allLoginChecks = true;
        if ( name.isEmpty() ) {
            showErrorWindow("Error", "Du hast keinen Profilnamen angegeben!");
            allLoginChecks = false;
        }
        else if ( pw.isEmpty() ) {
            showErrorWindow("Error", "Du hast kein Passwort eingegeben!");
            allLoginChecks = false;
        }
        if ( allLoginChecks ) {
            new ConfirmLogin(name, pw);
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
        String newPW = passwordTF.getText();
        String newConfirmPW = cpasswordTF.getText();

        boolean allNewProfileChecks = true;
        if (profileName.isEmpty()) {
            showErrorWindow("Ungültige Eingabe", "Du hast keinen Profilnamen angegeben!");
            allNewProfileChecks = false;
        }

        else if (newPW.isEmpty()) {
            showErrorWindow("Ungültige Eingabe", "Du hast kein Passwort eingegeben!");
            allNewProfileChecks = false;
        }

        else if (newPW.length()<8) {
            showErrorWindow("Ungültige Eingabe", "Dein Passwort muss mindestens 8 Zeichen haben!");
            allNewProfileChecks = false;
        }

        else if (newConfirmPW.isEmpty()) {
            showErrorWindow("Ungültige Eingabe", "Du musst dein Passwort bestätigen!");
            allNewProfileChecks = false;
        }

        else if (!newPW.equals(newConfirmPW)) {
            showErrorWindow("Ungültige Eingabe", "Deine Passwörter stimmen nicht überein!");
            allNewProfileChecks = false;
        }

    if (allNewProfileChecks) {
        new PasswordHasher.hashPassword(profileName, newPW);
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