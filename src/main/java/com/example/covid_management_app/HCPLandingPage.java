package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HCPLandingPage {
    @javafx.fxml.FXML
    private AnchorPane top;
    @javafx.fxml.FXML
    private AnchorPane left;
    @javafx.fxml.FXML
    private BorderPane borderpane;
    @javafx.fxml.FXML
    private AnchorPane bottom;
    @javafx.fxml.FXML
    private AnchorPane center;
    @javafx.fxml.FXML
    private Label nameLable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private User user;

    public void initData(User user) {
        this.user = user;
    }

    @javafx.fxml.FXML
    public void bookappointmentscene(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void testresultscene(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HCP_ViewPatientTestResult.fxml"));
            BorderPane pane = loader.load();
            HCPViewPatientTestResult controller = loader.getController();
            controller.initData(user);
            borderpane.setCenter(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void handleLogout(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            BorderPane pane = loader.load();
            borderpane.setCenter(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void dashboardscene(ActionEvent actionEvent) {
    }
}