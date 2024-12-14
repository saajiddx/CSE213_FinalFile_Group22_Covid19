package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

public class AdminGenerateCOVID19Reports {
    @javafx.fxml.FXML
    private ComboBox reportTypeCombo;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }

    @javafx.fxml.FXML
    public void handleGenerate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDownload(ActionEvent actionEvent) {
    }
}