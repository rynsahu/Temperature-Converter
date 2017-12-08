package com.aryan.TemperatureConverter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Button convertBtn;

    @FXML
    public TextField tempTextField;


    @FXML
    public ChoiceBox<String> chooseOpt;

    private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT = "Fahrenheit to Celsius";

    private boolean isC_TO_F = true;

    @FXML
    public Label wellcomeLable;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chooseOpt.getItems().add(C_TO_F_TEXT);
        chooseOpt.getItems().add(F_TO_C_TEXT);

        chooseOpt.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {

            if (newValue.equals("Celsius to Fahrenheit")){
                isC_TO_F = true;
            }else {
                isC_TO_F = false;
            }
        });

        chooseOpt.setValue(C_TO_F_TEXT);

        convertBtn.setOnAction(actionEvent -> {

            convert();
        });
    }

    private void convert() {

        String input = tempTextField.getText();
        float enteredTemperature = 0.0f;

        try {
            enteredTemperature = Float.parseFloat(input);
        }catch (Exception ex){
            warnUser();
            return;
        }

        float newTemperature = 0.0f;

        if (isC_TO_F){
            newTemperature = (enteredTemperature * 9/5) + 32;
        }else {
            newTemperature = (enteredTemperature -32) * 5/9;
        }

        display(newTemperature);
    }

    private void warnUser() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter the valid temperature.");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit = isC_TO_F? "F" : "C";

        System.out.println("The new temperature is  : " + newTemperature + unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new temperature is : " + newTemperature +" " + unit);
        alert.show();
    }

}