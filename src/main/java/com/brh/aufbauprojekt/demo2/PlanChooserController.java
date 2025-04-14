package com.brh.aufbauprojekt.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlanChooserController {
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label trainLabel1;
    @FXML
    private Label trainLabel2;
    @FXML
    private Label trainLabel3;
    @FXML
    private Label trainLabel4;
    @FXML
    private Label trainLabel5;
    @FXML
    private Label trainLabel6;
    @FXML
    private Label trainLabel7;
    @FXML
    private Label kwWeekLabel;
    @FXML
    public void initialize() {
        kwWeekLabel.setText ( CalendarModel.getChosenYear() + " Woche: " + CalendarModel.getChosenWeekNumber() );
        ArrayPrinter();
        setTrainingPlans();
    }

    public void setTrainingPlans() {
        boolean[] chosenDays2 = {true};
        boolean[] chosenDays = TrainingPlanModel.chosenDays;
        String text = "Übereinstimmung ab Index: ";
        findFirstMatchingIndex(chosenDays, chosenDays2, text);
        fillBoxes();
    }


    public static void ArrayPrinter() {
        boolean[] array = TrainingPlanModel.chosenDays;
        for (int i = 0; i < array.length; i++) {
            System.out.println("Wert auf Index " + i + ": " + array[i]);
        }
    }
    public static void createNewPlan(int index, String text) {
        System.out.println(text + index);
    }

    public static int findFirstMatchingIndex(boolean[] longerArray, boolean[] shorterArray, String text) {
        if (shorterArray.length > longerArray.length) {
            return -1;
        }

        for (int i = 0; i <= longerArray.length - shorterArray.length; i++) {
            boolean match = true;
            for (int j = 0; j < shorterArray.length; j++) {
                if (longerArray[i + j] != shorterArray[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                createNewPlan(i, text);
            }
        }
        System.out.println("Keine Übereinstimmung gefunden.");
        return -1;
    }


String redText = ("-fx-font-size: 33px; -fx-text-fill: red; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String blackText = ("-fx-font-size: 33px; -fx-text-fill: navy; -fx-font-family: \"Arial\"; -fx-font-weight: bold; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 5, 0.3, 0, 1);");
String greenText = ("-fx-font-size: 33px; -fx-text-fill: green; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String blueText = ("-fx-font-size: 33px; -fx-text-fill: blue; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String yellowText = ("-fx-font-size: 33px; -fx-text-fill: yellow; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String orangeText = ("-fx-font-size: 33px; -fx-text-fill: orange; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String purpleText = ("-fx-font-size: 33px; -fx-text-fill: purple; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String whiteText = ("-fx-font-size: 33px; -fx-text-fill: white; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String greyText = ("-fx-font-size: 33px; -fx-text-fill: grey; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String brownText = ("-fx-font-size: 33px; -fx-text-fill: brown; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String pinkText = ("-fx-font-size: 33px; -fx-text-fill: pink; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String cyanText = ("-fx-font-size: 33px; -fx-text-fill: cyan; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");
String magentaText = ("-fx-font-size: 33px; -fx-text-fill: magenta; -fx-font-family: \"Arial\"; -fx-font-weight: bold;-fx-effect: dropshadow(gaussian, rgba(50, 0, 0, 1), 5, 0.3, 0, 1);");


    public void fillBoxes() {
//        if (TrainingPlanModel.getDaysPerWeek() == 1) {
            String text = "OK";
            trainLabel1.setText(text);
            trainLabel1.setStyle(blueText);

            trainLabel2.setText(text);
            trainLabel2.setStyle(greenText);

            trainLabel3.setText(text);
            trainLabel3.setStyle(orangeText);

            trainLabel4.setText(text);
            trainLabel4.setStyle(magentaText);

            trainLabel5.setText(text);
            trainLabel5.setStyle(redText);

            trainLabel6.setText(text);
            trainLabel6.setStyle(cyanText);

            trainLabel7.setText(text);
            trainLabel7.setStyle(pinkText);

        }
//    }

    @FXML
    protected void onChoosePlanClick1(ActionEvent event) {
        System.out.println("Plan 1 ausgewählt");
    }
    @FXML
    protected void onChoosePlanClick2(ActionEvent event) {
        System.out.println("Plan 2 ausgewählt");
    }
    @FXML
    protected void onChoosePlanClick3(ActionEvent event) {

    }
    @FXML
    protected void onChoosePlanClick4(ActionEvent event) {

    }
    @FXML
    protected void onChoosePlanClick5(ActionEvent event) {

    }
    @FXML
    protected void onChoosePlanClick6(ActionEvent event) {

    }
    @FXML
    protected void onChoosePlanClick7(ActionEvent event) {

    }
    @FXML
    protected void onChoosePlanClick8(ActionEvent event) {

    }
    @FXML
    protected void onChoosePlanClick9(ActionEvent event) {

    }
    @FXML
    protected void onChoosePlanClick10(ActionEvent event) {

    }
    @FXML
    protected void onConfirmClick(ActionEvent event) {
        System.out.println("Plan bestätigt");
    }
}

