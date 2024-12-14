package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class GeneralProvideFeedback {
    @javafx.fxml.FXML
    private TextArea feedbackArea;
    @javafx.fxml.FXML
    private ComboBox ratingCombo;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }

    @javafx.fxml.FXML
    public void handleSubmit(ActionEvent actionEvent) {
    }
}