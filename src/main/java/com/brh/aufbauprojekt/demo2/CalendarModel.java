package com.brh.aufbauprojekt.demo2;

public class CalendarModel {
    public static String profileName;
    public static int currentWeekNumber;

    public static int getCurrentWeekNumber() {
        return currentWeekNumber;
    }

    public static void setCurrentWeekNumber(int currentWeekNumber) {
        CalendarModel.currentWeekNumber = currentWeekNumber;
    }

    public static int getCurrentDay() {
        return currentDay;
    }

    public static void setCurrentDay(int currentDay) {
        CalendarModel.currentDay = currentDay;
    }

    public static int getCurrentMonth() {
        return currentMonth;
    }

    public static void setCurrentMonth(int currentMonth) {
        CalendarModel.currentMonth = currentMonth;
    }

    public static int getCurrentYear() {
        return currentYear;
    }

    public static void setCurrentYear(int currentYear) {
        CalendarModel.currentYear = currentYear;
    }

    public static int currentDay;
    public static int currentMonth;
    public static int currentYear;

    public static String getProfileName() {
        return profileName;
    }

    public static void setProfileName(String profileName) {
        CalendarModel.profileName = profileName;
    }

    public static int getChosenWeekNumber() {
        return chosenWeekNumber;
    }

    public static void setChosenWeekNumber(int chosenWeekNumber) {
        CalendarModel.chosenWeekNumber = chosenWeekNumber;
    }

    public static int getChosenDay() {
        return chosenDay;
    }

    public static void setChosenDay(int chosenDay) {
        CalendarModel.chosenDay = chosenDay;
    }

    public static int getChosenMonth() {
        return chosenMonth;
    }

    public static void setChosenMonth(int chosenMonth) {
        CalendarModel.chosenMonth = chosenMonth;
    }

    public static int getChosenYear() {
        return chosenYear;
    }

    public static void setChosenYear(int chosenYear) {
        CalendarModel.chosenYear = chosenYear;
    }

    public static int chosenWeekNumber;
    public static int chosenDay;
    public static int chosenMonth;
    public static int chosenYear;



}

