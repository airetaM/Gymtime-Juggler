package com.brh.aufbauprojekt.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.time.LocalDate;
import java.util.Locale;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
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
        String profileName = CalendarModel.getProfileName();
        profileLabel.setText(profileName);
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = selectedDate.get(weekFields.weekOfWeekBasedYear());
        int day = selectedDate.get(weekFields.dayOfWeek());
        int Month = selectedDate.getMonthValue();
        updateMonth(Month);
        kwField.setText("KW " + weekNumber);
        yearField.setText("" + selectedDate.getYear());
        checkStyles(day);
        setDayNumbers(selectedDate, day);
    }

    @FXML
    protected void onSaveWeekClick() {
        System.out.println("woche gespeichert");
    }

    @FXML
    protected void onCreatePlanClick() {
        System.out.println("plan erstellt");
    }

    LocalDate date = LocalDate.now();

    @FXML
    protected void onEnteredDate() {
        LocalDate selectedDate = DatePicker.getValue();
        if (selectedDate != null) {
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            int weekNumber = selectedDate.get(weekFields.weekOfWeekBasedYear());
            int day = selectedDate.get(weekFields.dayOfWeek());
            int Month = selectedDate.getMonthValue();
            int currentYear = selectedDate.getYear();
            //todo: datemodel
            CalendarModel.setChosenWeekNumber(weekNumber);
            CalendarModel.setChosenDay(day);
            CalendarModel.setChosenMonth(Month);
            CalendarModel.setChosenYear(currentYear);

            System.out.println("woche: " + weekNumber + " tag: " + day + " monat: " + Month + " jahr: " + currentYear);
            kwField.setText("KW " + weekNumber);
            updateMonth(Month);
            yearField.setText("" + selectedDate.getYear());
//                todayField.setText("Monat: " + selectedDate.getMonthValue() + " Tag: " + selectedDate.getDayOfMonth());
            setDayNumbers(selectedDate, day);
            checkStyles(day);
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
        if (LocalDate.now().getYear() == CalendarModel.getCurrentYear()) {
            if (CalendarModel.getChosenWeekNumber() == CalendarModel.getCurrentWeekNumber()) {
                System.out.println(""+LocalDate.now().getDayOfYear());
                System.out.println("current:"+CalendarModel.getCurrentDay());
                System.out.println("chosen"+CalendarModel.getChosenDay());
                // LocalDate.now().getDayOfWeek().getValue()
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




