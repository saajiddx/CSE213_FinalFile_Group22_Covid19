package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Signup {
    @javafx.fxml.FXML
    private ComboBox<String> roleCombo;
    @javafx.fxml.FXML
    private PasswordField enterPassField;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private PasswordField ConfirmPassField;
    @javafx.fxml.FXML
    private DatePicker dobField;
    @javafx.fxml.FXML
    private TextArea addressField;
    @javafx.fxml.FXML
    private Label error;
    @javafx.fxml.FXML
    private TextField phoneField;

    @javafx.fxml.FXML
    public void initialize() {
        roleCombo.getItems().addAll("General Public", "Admin", "Health Care Provider", "Mental Health Professionals",
                "Researchers", " Policy Makers", "Local Community Organizations", " Local Community Organizations");
    }

    @javafx.fxml.FXML
    public void handleSubmit(ActionEvent actionEvent) {

        ArrayList<User> users = new ArrayList<>();

        // Retrieve input from fields
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        String address = addressField.getText().trim();
        String confirmPass = ConfirmPassField.getText().trim();
        String enterPass = enterPassField.getText().trim();
        LocalDate dob = dobField.getValue();
        LocalDate date = LocalDate.now();

        // Validation checks
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || confirmPass.isEmpty()
                || dob == null) {
            System.out.println("Error: All fields are required.");
            error.setText("Error: All fields are required.");
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("Error: Invalid email format.");
            error.setText("Error: Invalid email format.");
            return;
        }

        if (!enterPass.equals(confirmPass)) {
            error.setText("Error: Passwords do not match.");
            return;
        }
        if (enterPass.length() < 6) {
            error.setText("Error: Passwords must contain at least 6 characters.");
            return;
        }

        if (!phone.matches("^\\d{11}$")) { // Assuming 11-digit phone numbers
            System.out.println("Error: Invalid phone number format.");
            error.setText("Error: Invalid phone number format.");
            return;
        }

        if (dob.isAfter(date.minusYears(6))) { // Assuming age validation: must be 18 or older
            System.out.println("Error: ");
            error.setText("Error: You must be at least 6 years old.");
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
            if (u.getEmail().equals(email)) {
                error.setText("Error: Email already in use.");
                return;
            }
        }

        // Proceed with file operations
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Users.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            User u = new User(email, name, confirmPass, address, phone, roleCombo.getValue(), dob, date);
            oos.writeObject(u);

            System.out.println("User successfully registered.");
        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @javafx.fxml.FXML
    public void gotoLogin(ActionEvent actionEvent) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
}