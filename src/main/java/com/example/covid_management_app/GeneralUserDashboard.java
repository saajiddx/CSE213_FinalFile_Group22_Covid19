package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GeneralUserDashboard {
    @javafx.fxml.FXML
    private Label nameLable;
    @javafx.fxml.FXML
    private AnchorPane top;
    @javafx.fxml.FXML
    private AnchorPane left;
    @javafx.fxml.FXML
    private AnchorPane bottom;
    @javafx.fxml.FXML
    private AnchorPane center;
    @javafx.fxml.FXML
    private BorderPane borderpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private User user;

    public void initData(User user) {
        this.user = user;
        nameLable.setText(user.getName());
    }

    @javafx.fxml.FXML
    public void bookappointmentscene(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BookingAppointment.fxml"));
        Parent root = loader.load();

        BookingAppointment controller = loader.getController();
        controller.initData(user);

        borderpane.setCenter(root);
    }

    @javafx.fxml.FXML
    public void testresultscene(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardscene(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLogout(ActionEvent actionEvent) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
}