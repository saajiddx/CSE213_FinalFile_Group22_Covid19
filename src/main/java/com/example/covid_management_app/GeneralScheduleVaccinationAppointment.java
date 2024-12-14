package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class GeneralScheduleVaccinationAppointment {
    @javafx.fxml.FXML
    private DatePicker appointmentField;
    @javafx.fxml.FXML
    private Label error;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }

    @javafx.fxml.FXML
    public void handleAvailability(ActionEvent actionEvent) {
    }
}