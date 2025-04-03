package com.brh.aufbauprojekt.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.time.LocalDate;
import java.util.Locale;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MainController {
    @FXML
    private TextArea textBox1;
    @FXML
    private TextArea textBox2;
    @FXML
    private TextArea textBox3;
    @FXML
    private TextArea textBox4;
    @FXML
    private TextArea textBox5;
    @FXML
    private TextArea textBox6;
    @FXML
    private TextArea textBox7;
    @FXML
    private TextArea textBox8;
    @FXML
    private TextArea textBox9;
    @FXML
    private TextArea textBox10;
    @FXML
    private TextArea textBox11;
    @FXML
    private TextArea textBox12;
    @FXML
    private TextArea textBox13;
    @FXML
    private TextArea textBox14;
    @FXML
    private TextArea textBox15;
    @FXML
    private TextArea textBox16;
    @FXML
    private TextArea textBox17;
    @FXML
    private TextArea textBox18;
    @FXML
    private TextArea textBox19;
    @FXML
    private TextArea textBox20;
    @FXML
    private TextArea textBox21;
    @FXML
    private TextArea textBox22;
    @FXML
    private TextArea textBox23;
    @FXML
    private TextArea textBox24;
    @FXML
    private TextArea textBox25;
    @FXML
    private TextArea textBox26;
    @FXML
    private TextArea textBox27;
    @FXML
    private TextArea textBox28;
    @FXML
    private TextArea textBox29;
    @FXML
    private TextArea textBox30;
    @FXML
    private TextArea textBox31;
    @FXML
    private TextArea textBox32;
    @FXML
    private TextArea textBox33;
    @FXML
    private TextArea textBox34;
    @FXML
    private TextArea textBox35;
    @FXML
    private TextArea textBox36;
    @FXML
    private TextArea textBox37;
    @FXML
    private TextArea textBox38;
    @FXML
    private TextArea textBox39;
    @FXML
    private TextArea textBox40;
    @FXML
    private TextArea textBox41;
    @FXML
    private TextArea textBox42;

    @FXML
    private Label dayNumber1;
    @FXML
    private Label dayNumber2;
    @FXML
    private Label dayNumber3;
    @FXML
    private Label dayNumber4;
    @FXML
    private Label dayNumber5;
    @FXML
    private Label dayNumber6;
    @FXML
    private Label dayNumber7;

    @FXML
    private DatePicker DatePicker;
    @FXML
    private Label kwField;
    @FXML
    private Label yearField;
    @FXML
    private Label monthField;
    @FXML
    private Label profileLabel;

    @FXML
    private LocalDate Now;
    @FXML
    private DateTimeFormatter DateTimeFormatter;

    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    @FXML
    private Label dayID1;
    @FXML
    private Label dayID2;
    @FXML
    private Label dayID3;
    @FXML
    private Label dayID4;
    @FXML
    private Label dayID5;
    @FXML
    private Label dayID6;
    @FXML
    private Label dayID7;
    @FXML
    private Label clockID;

    private boolean isBlack;

    @FXML
    public void initialize() {
        DatePicker.getEditor().setText(date.toString());
        saveToday();
        confirmDateFromText();
        startClock();
        String profileName = CalendarModel.getProfileName();
        profileLabel.setText(profileName);
    }

    protected void saveToday() {
        LocalDate selectedDate = LocalDate.now();
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            int currentWeekNumber = selectedDate.get(weekFields.weekOfWeekBasedYear());
            int currentDay = LocalDate.now().getDayOfMonth();
            int currentMonth = selectedDate.getMonthValue();
            int currentYear = selectedDate.getYear();
            CalendarModel.setCurrentWeekNumber(currentWeekNumber);
            CalendarModel.setCurrentDay(currentDay);
            CalendarModel.setCurrentMonth(currentMonth);
            CalendarModel.setCurrentYear(currentYear);
            CalendarModel.setChosenWeekNumber(currentWeekNumber);
            CalendarModel.setChosenDay(currentDay);
            CalendarModel.setChosenMonth(currentMonth);
            CalendarModel.setChosenYear(currentYear);
            CalendarModel.setChosenDate(selectedDate);
    }

    @FXML
    protected void confirmDateFromText() {
        String dateText = DatePicker.getEditor().getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate selectedDate = LocalDate.parse(dateText, formatter);
        DatePicker.setValue(selectedDate);
        updateLabels(selectedDate);
    }

    private void updateLabels(LocalDate selectedDate) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = selectedDate.get(weekFields.weekOfWeekBasedYear());
        int day = selectedDate.get(weekFields.dayOfWeek());
        int Month = selectedDate.getMonthValue();
        updateMonth(Month);
        kwField.setText("KW " + weekNumber);
        yearField.setText("" + selectedDate.getYear());
        checkStyles(day);
        setDayNumbers(selectedDate, day);
        fillTextBoxes();
    }

    private void fillTextBoxes() {
        // First clear all textboxes
        for (int i = 1; i <= 42; i++) {
            try {
                TextArea textBox = (TextArea) getClass().getDeclaredField("textBox" + i).get(this);
                textBox.clear();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        String profileName = CalendarModel.getProfileName();
        int year = CalendarModel.getChosenYear();
        int weekNumber = CalendarModel.getChosenWeekNumber();
        File file = new File(profileName + "_" + year + "_" + weekNumber + ".json");

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                JSONObject jsonObject = new JSONObject(new JSONTokener(reader));
                JSONArray textBoxes = jsonObject.getJSONArray("textBoxes");

                for (int i = 0; i < textBoxes.length(); i++) {
                    JSONObject textBoxObject = textBoxes.getJSONObject(i);
                    String textBoxID = textBoxObject.getString("textBoxID");
                    String text = textBoxObject.getString("text");

                    TextArea textBox = (TextArea) getClass().getDeclaredField(textBoxID).get(this);
                    textBox.setText(text);
                }
            } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    protected void onSaveWeekClick() throws NoSuchFieldException, IllegalAccessException {
        JSONObject jsonObject = new JSONObject();
        int chosenYear = CalendarModel.getChosenYear();
        int chosenWeekNumber = CalendarModel.getChosenWeekNumber();
        jsonObject.put("year", chosenYear);
        jsonObject.put("weekNumber", chosenWeekNumber);
        ShortLivedWindow(chosenYear, chosenWeekNumber);

        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < 42; i++) {
            String textBoxID = "textBox" + (i + 1);
            try {
                TextArea textBox = (TextArea) getClass().getDeclaredField(textBoxID).get(this);
                String text = textBox.getText();
                JSONObject textBoxObject = new JSONObject();
                textBoxObject.put("textBoxID", textBoxID);
                textBoxObject.put("text", text);
                jsonArray.put(textBoxObject);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        jsonObject.put("textBoxes", jsonArray);

        try (FileWriter file = new FileWriter(CalendarModel.getProfileName() + "_" + CalendarModel.getChosenYear() + "_" + CalendarModel.getChosenWeekNumber() + ".json")) {
            file.write(jsonObject.toString(4)); // 4 is the indentation level
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void ShortLivedWindow(int chosenYear, int chosenWeekNumber) {
        Alert window = new Alert(Alert.AlertType.INFORMATION);
        window.setTitle("Information");
        window.setHeaderText(null);
        window.setContentText( chosenYear + " KW " + chosenWeekNumber + " wurde gespeichert." );
        window.setResizable(false);
        window.show();

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(2000),
                ae -> window.close()
        ));
        timeline.setCycleCount(1);
        timeline.play();
    }


    @FXML
    protected void onCreatePlanClick() {
        System.out.println("plan erstellt");
    }

    LocalDate date = LocalDate.now();
    @FXML
    protected void onBackArrowClick() {
        LocalDate selectedDate = CalendarModel.getChosenDate().minusDays(7);
        int selectedWeek = CalendarModel.getChosenWeekNumber();
        if (selectedWeek > 1) {
            selectedWeek -= 1;
        } else {
            selectedWeek = 52;
            int chosenYear = (CalendarModel.getChosenYear()-1);
            CalendarModel.setChosenYear(chosenYear);
        }
        CalendarModel.setChosenWeekNumber(selectedWeek);
        CalendarModel.setChosenDate(selectedDate);
        updateLabels(selectedDate);
        DatePicker.setValue(selectedDate);
    }
    @FXML
    protected void onForwardArrowClick() {
        LocalDate selectedDate = CalendarModel.getChosenDate().plusDays(7);
        int selectedWeek = CalendarModel.getChosenWeekNumber();
        if (selectedWeek < 52) {
            selectedWeek += 1;
        } else {
            selectedWeek = 1;
            int chosenYear = (CalendarModel.getChosenYear()+1);
            CalendarModel.setChosenYear(chosenYear);
        }
        CalendarModel.setChosenWeekNumber(selectedWeek);
        CalendarModel.setChosenDate(selectedDate);
        updateLabels(selectedDate);
        DatePicker.setValue(selectedDate);
    }
    @FXML
    protected void onEnteredDate() {
        LocalDate selectedDate = DatePicker.getValue();
        if (selectedDate != null) {
            CalendarModel.setChosenDate(selectedDate);
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            int weekNumber = selectedDate.get(weekFields.weekOfWeekBasedYear());
            int day = selectedDate.get(weekFields.dayOfWeek());
            int Month = selectedDate.getMonthValue();
            int currentYear = selectedDate.getYear();
            CalendarModel.setChosenWeekNumber(weekNumber);
            CalendarModel.setChosenDay(day);
            CalendarModel.setChosenMonth(Month);
            CalendarModel.setChosenYear(currentYear);
            updateLabels(selectedDate);
        }
    }

    private void setDayNumbers(LocalDate selectedDate, int day) {
        Label[] dayNumbers = {dayNumber1, dayNumber2, dayNumber3, dayNumber4, dayNumber5, dayNumber6, dayNumber7};
        while (day > 1) {
            dayNumbers[day - 1].setText(selectedDate.getDayOfMonth() + "");
            day--;
            selectedDate = selectedDate.minusDays(1);
        }

        while (day < 7) {
            dayNumbers[day - 1].setText(selectedDate.getDayOfMonth() + "");
            day++;
            selectedDate = selectedDate.plusDays(1);
        }
        dayNumbers[6].setText(selectedDate.getDayOfMonth() + "");
    }

    private void checkStyles(int day) {
        if (CalendarModel.getCurrentYear() == CalendarModel.getChosenYear() && CalendarModel.getChosenWeekNumber() == CalendarModel.getCurrentWeekNumber() ) {
               if (day == CalendarModel.getCurrentDay() + 1 || isBlack) {
                    isBlack = false;
                    String numberStyle = "-fx-font-size:22; -fx-text-fill: red; -fx-font-weight: bold; -fx-font-family: 'Comic Sans MS', sans-serif;";
                    String boxStyle = "-fx-border-width: 5px; -fx-border-color: red; -fx-background-color: #ffe6e6;";
                    String blackNumberStyle = "-fx-font-size:18; -fx-text-fill: black; -fx-font-weight: normal; -fx-font-family: 'Comic Sans MS', sans-serif;";
                    String blackBoxStyle = "-fx-border-width: 2px; -fx-border-color: black; -fx-background-color: #acfcef;";
                    day = CalendarModel.getCurrentDay() + 1;
                    setStyles(day, numberStyle, boxStyle, blackNumberStyle, blackBoxStyle);
              }
        } else {
            isBlack = true;
            String numberStyle = "-fx-font-size:18; -fx-text-fill: black; -fx-font-weight: normal; -fx-font-family: 'Comic Sans MS', sans-serif;";
            String boxStyle = "-fx-border-width: 2px; -fx-border-color: black; -fx-background-color: #acfcef;";
            String blackNumberStyle = "-fx-font-size:18; -fx-text-fill: black; -fx-font-weight: normal; -fx-font-family: 'Comic Sans MS', sans-serif;";
            String blackBoxStyle = "-fx-border-width: 2px; -fx-border-color: black; -fx-background-color: #acfcef;";
            setStyles(day, numberStyle, boxStyle, blackNumberStyle, blackBoxStyle);
        }
    }
    private void setStyles(int day, String numberStyle, String boxStyle, String blackNumberStyle, String blackBoxStyle) {
        Label[] dayNumbers = {dayNumber1, dayNumber2, dayNumber3, dayNumber4, dayNumber5, dayNumber6, dayNumber7};
        Label[] dayIDs = {dayID1, dayID2, dayID3, dayID4, dayID5, dayID6, dayID7};
        for (int i = 0; i < dayNumbers.length; i++) {
            if (day == i + 1) {
                dayNumbers[i].setStyle(numberStyle);
                dayIDs[i].setStyle(numberStyle + boxStyle);
            } else {
                dayNumbers[i].setStyle(blackNumberStyle);
                dayIDs[i].setStyle(blackNumberStyle + blackBoxStyle);
            }
       }
    }

    private void startClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            clockID.setText(currentTime.format(timeFormatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Timeline.INDEFINITE);
        clock.play();
    }

    private void updateMonth(int Month) {
        String[] Monthnames = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
        for (int i = 0; i < Monthnames.length; i++) {
            if (Month == i + 1) {
                monthField.setText(Monthnames[i]);
            }
        }
    }
}




