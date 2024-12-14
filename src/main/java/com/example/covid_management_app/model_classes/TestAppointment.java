package com.example.covid_management_app.model_classes;

import java.io.Serializable;
import java.time.LocalDate;

public class TestAppointment implements Serializable {
    private String patientEmail, status, result, location;
    private LocalDate bookingDate, appointmentDate;

    public TestAppointment(String patientEmail, String status, String result, String location, LocalDate bookingDate, LocalDate appointmentDate) {
        this.patientEmail = patientEmail;
        this.status = status;
        this.result = result;
        this.location = location;
        this.bookingDate = bookingDate;
        this.appointmentDate = appointmentDate;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
