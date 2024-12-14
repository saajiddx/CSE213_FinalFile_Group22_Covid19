package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.scene.chart.ScatterChart;

public class GeneralCOVID19HotspotsMap {
    @javafx.fxml.FXML
    private ScatterChart chart;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }
}