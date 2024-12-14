package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.TestResult;
import com.example.covid_management_app.model_classes.User;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class HCPViewPatientTestResult {
    @javafx.fxml.FXML
    private TableColumn<TestResult, String> resultColumn;
    @javafx.fxml.FXML
    private TableColumn<TestResult, LocalDate> testDateColumn;
    @javafx.fxml.FXML
    private TableColumn<TestResult, String> patientEmailColumn;
    @javafx.fxml.FXML
    private TableColumn<TestResult, String> commentsColumn;
    @javafx.fxml.FXML
    private TableColumn<TestResult, Integer> idColumn;

    @javafx.fxml.FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<TestResult, Integer>("id"));
        patientEmailColumn.setCellValueFactory(new PropertyValueFactory<TestResult, String>("patientEmail"));
        testDateColumn.setCellValueFactory(new PropertyValueFactory<TestResult, LocalDate>("testDate"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<TestResult, String>("result"));
        commentsColumn.setCellValueFactory(new PropertyValueFactory<TestResult, String>("comments"));
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }
}