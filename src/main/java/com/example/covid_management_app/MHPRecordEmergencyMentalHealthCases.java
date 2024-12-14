package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MHPRecordEmergencyMentalHealthCases {
    @javafx.fxml.FXML
    private TextArea detailsField;
    @javafx.fxml.FXML
    private Button handleSubmit;
    @javafx.fxml.FXML
    private TextField symptomsField;
    @javafx.fxml.FXML
    private TextField emailField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }
}