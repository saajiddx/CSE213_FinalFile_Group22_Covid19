package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;

public class AdminLandingPage {
    @javafx.fxml.FXML
    public void initialize() {
    }

    User user;

    public void initData(User user) {
        this.user = user;
    }
}