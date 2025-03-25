package com.brh.aufbauprojekt.demo2;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONHandler {
    private static String USER = "User";
    private static String PW = "PW";
    private static final String FILE_PATH = "data.json";
    static JSONArray jsonArray;

    public static class saveProfileData {
        public saveProfileData(String profileName, String hashedPW) {
            File file = new File(FILE_PATH);
            JSONArray jsonArray;

            if (file.exists()) {
                try (FileReader reader = new FileReader(file)) {
                    Object json = new JSONTokener(reader).nextValue();
                    if (json instanceof JSONArray) {
                        jsonArray = (JSONArray) json;
                    } else {
                        System.err.println("Error: Kein JSON array.");
                        jsonArray = new JSONArray();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } else {
                jsonArray = new JSONArray(); // Neues JSONArray wenn die Datei nicht existiert
            }

            org.json.JSONObject jsonObject = new org.json.JSONObject();
            jsonObject.put(USER, profileName);
            jsonObject.put(PW, hashedPW);

            try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
                jsonArray.put(jsonObject);
                fileWriter.write(jsonArray.toString(4)); // 4 ist die Einrückung
                System.out.println("Neues Profil mit dem Namen: " + profileName + " wurde erstellt.");
                    App.changeSceneToMainMenu("mainMenu.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean checkUserPassword(String profileName, String inputPassword) {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                jsonArray = new JSONArray(new JSONTokener(reader));
                for (int i = 0; i < jsonArray.length(); i++) {
                    org.json.JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (jsonObject.getString(USER).equals(profileName)) {
                        String hashedPassword = jsonObject.getString(PW);
                        return PasswordHasher.checkPassword(inputPassword, hashedPassword);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}