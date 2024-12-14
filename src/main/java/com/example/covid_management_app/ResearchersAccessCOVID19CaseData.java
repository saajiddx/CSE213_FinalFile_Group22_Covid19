package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.event.ActionEvent;

public class ResearchersAccessCOVID19CaseData {
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleDownloadCSV(ActionEvent actionEvent) {
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }
}