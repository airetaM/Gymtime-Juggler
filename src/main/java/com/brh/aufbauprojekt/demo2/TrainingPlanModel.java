package com.brh.aufbauprojekt.demo2;

public class TrainingPlanModel {

    public static int daysPerWeek;
    public static boolean[] chosenDays = new boolean[7];

    public static int getDaysPerWeek() {
        return daysPerWeek;
    }

    public static void setDaysPerWeek(int daysPerWeek) {
        TrainingPlanModel.daysPerWeek = daysPerWeek;
    }

}
