package com.example.covid_management_app;

import com.example.covid_management_app.model_classes.TestAppointment;
import com.example.covid_management_app.model_classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingAppointment {
    @javafx.fxml.FXML
    private DatePicker appointmentField;
    @javafx.fxml.FXML
    private TableColumn<TestAppointment, LocalDate> appintmentCol;
    @javafx.fxml.FXML
    private TableColumn<TestAppointment, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<TestAppointment, LocalDate> bookingCol;
    @javafx.fxml.FXML
    private TableColumn<TestAppointment, String> resultCol;
    @javafx.fxml.FXML
    private TableColumn<TestAppointment, String> locationCol;

    @javafx.fxml.FXML
    private TableView<TestAppointment> table;
    @javafx.fxml.FXML
    private Label error;
    private User user;
    @javafx.fxml.FXML
    private ComboBox<String> locations;

    ObservableList<TestAppointment> talist = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        appintmentCol.setCellValueFactory(new PropertyValueFactory<TestAppointment, LocalDate>("appointmentDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<TestAppointment, String>("status"));
        bookingCol.setCellValueFactory(new PropertyValueFactory<TestAppointment, LocalDate>("bookingDate"));
        resultCol.setCellValueFactory(new PropertyValueFactory<TestAppointment, String>("result"));
        locationCol.setCellValueFactory(new PropertyValueFactory<TestAppointment, String>("location"));


        locations.getItems().addAll("CMH", "Appolo", "United Hospital", "Kurmitola General Hospital");


        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("TestAppointments.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            TestAppointment ta;
            try {
                while (true) {
                    ta = (TestAppointment) ois.readObject();
                    System.out.println(ta.getPatientEmail());
                    if (ta.getPatientEmail().equals(user.getEmail())) {
                        talist.add(ta);
                    }
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

        table.setItems(talist);
    }


    public void initData(User user) {
        this.user = user;
    }

    @javafx.fxml.FXML
    public void handleAvailability(ActionEvent actionEvent) {
        LocalDate appointmentDate = appointmentField.getValue();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("TestAppointments.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            TestAppointment ta;
            try {
                while (true) {
                    ta = (TestAppointment) ois.readObject();
                    if (ta.getAppointmentDate().equals(appointmentDate) && locations.getValue().equals(ta.getLocation())) {
                        error.setText("Location and Date slot is not available..");
                        return;
                    }
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

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("TestAppointments.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            TestAppointment ta = new TestAppointment(user.getEmail(), "Appointed", "Null", locations.getValue(), (LocalDate) LocalDate.now(), appointmentDate);
            oos.writeObject(ta);
            talist.add(ta);
            error.setText("");
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
}
