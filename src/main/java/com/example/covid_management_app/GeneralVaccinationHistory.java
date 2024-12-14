package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GeneralVaccinationHistory {
    @javafx.fxml.FXML
    private TableColumn locationCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private TableColumn DoseCol;
    @javafx.fxml.FXML
    private TableColumn vaccinationCol;
    @javafx.fxml.FXML
    private TableColumn bookingDateCol;
    @javafx.fxml.FXML
    private TableView table;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }
}