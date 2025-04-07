package com.brh.aufbauprojekt.demo2;

import javafx.scene.control.Alert;

public class ConfirmLogin {

    public ConfirmLogin(String name, String pw) {
        try {
            if (isLoginValid(name, pw)) {}
        } catch (Exception _) {}
    }

    private boolean isLoginValid(String name, String pw) {
        boolean hashedPassword = JSONHandler.checkUserPassword(name, pw);
        if (hashedPassword) {
            System.out.println("Profil " + name + " wird geladen.");
            try {
                App.changeSceneToMainMenu("mainMenu.fxml", name);
            } catch (Exception e) {
                throw new RuntimeException(e);
        }
        } else {
            Alert window = new Alert(Alert.AlertType.ERROR);
            window.setTitle("Ungültige Eingabe");
            window.setHeaderText(null);
            window.setResizable(false);
            window.setContentText( "Profilname oder Passwort falsch" );
            window.showAndWait();
        }
        return PasswordHasher.checkPassword(pw, String.valueOf(hashedPassword));
    }
}