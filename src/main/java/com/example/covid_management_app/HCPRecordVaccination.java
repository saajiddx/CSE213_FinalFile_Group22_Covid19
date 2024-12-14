package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import com.example.covid_management_app.model_classes.Vaccination;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDate;

public class HCPRecordVaccination {
    @javafx.fxml.FXML
    private ComboBox<String> vaccineComboBox;
    @javafx.fxml.FXML
    private TextField doseNumberTextField;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TextField paitentEmailField;

    @javafx.fxml.FXML
    public void initialize() {
        vaccineComboBox.getItems().addAll("Pfizer", "Moderna", "Johnson & Johnson");
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }

    public void handleVaccination(ActionEvent actionEvent) {
        try {
            File file = new File("Vaccination.bin");
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Vaccination vaccination = new Vaccination(
                    Vaccination.generateVaccinationId(),
                    vaccineComboBox.getSelectionModel().getSelectedItem().equals("Pfizer") ? 1 : 2,
                    LocalDate.now(),
                    user.getName(),
                    paitentEmailField.getText(),
                    Integer.parseInt(doseNumberTextField.getText()));
            oos.writeObject(vaccination);
            oos.close();
            fos.close();
            System.out.println("Vaccination record saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}