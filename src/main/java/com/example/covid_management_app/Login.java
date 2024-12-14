package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Login {
    @javafx.fxml.FXML
    private PasswordField passField;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private Label error;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSubmit(ActionEvent actionEvent) throws IOException {
        ArrayList<User> users = new ArrayList<>();

        String email = emailField.getText();
        String password = passField.getText();

        if (email == null || email.isEmpty()) {
            error.setText("Error: Email cannot be empty.");
            return;
        }
        if (password == null || password.isEmpty()) {
            error.setText("Error: Password cannot be empty.");
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("Error: Invalid email format.");
            error.setText("Error: Invalid email format.");
            return;
        }
        if (password.length() < 6) {
            error.setText("Error: Passwords must contain at least 6 characters.");
            return;
        }

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Users.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User u;
            try {
                while (true) {
                    u = (User) ois.readObject();
                    users.add(u);
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }

        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                System.out.println(password);
                System.out.println(email);
                String role = u.getRole();
                FXMLLoader loader = new FXMLLoader();
                Parent personViewParent = null;
                Scene personViewScene = null;
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                switch (role) {
                    case "Admin":
                        loader.setLocation(getClass().getResource("Admin_LandingPage.fxml"));
                        personViewParent = loader.load();
                        personViewScene = new Scene(personViewParent);
                        AdminLandingPage controller = loader.getController();
                        controller.initData(u);
                        break;

                    case "General Public":
                        loader.setLocation(getClass().getResource("GeneralUserDashboard.fxml"));
                        personViewParent = loader.load();
                        personViewScene = new Scene(personViewParent);
                        GeneralUserDashboard controllerCreditAnalyst = loader.getController();
                        controllerCreditAnalyst.initData(u);
                        break;
                    case "Health Care Provider":
                        loader.setLocation(getClass().getResource("HCP_LandingPage.fxml"));
                        personViewParent = loader.load();
                        personViewScene = new Scene(personViewParent);
                        HCPLandingPage gcpController = loader.getController();
                        gcpController.initData(u);
                        break;


                    default:
                        error.setText("Error: Invalid role.");
                        return;


                    // ... existing code for saving access log ...
                }
            }
            error.setText("Error: Invalid email or password.");
        }
    }


    @javafx.fxml.FXML
    public void goToSignup(ActionEvent actionEvent) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();

    }
}