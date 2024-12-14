package com.example.covid_management_app.model_classes;

import java.time.LocalDate;

public class VaccinationAppointment {
    private String patientEmail, status, location;
    private LocalDate bookingDate, appointmentDate;
    private int doses;

    public VaccinationAppointment(String patientEmail, String status, String location, LocalDate bookingDate, LocalDate appointmentDate, int doses) {
        this.patientEmail = patientEmail;
        this.status = status;
        this.location = location;
        this.bookingDate = bookingDate;
        this.appointmentDate = appointmentDate;
        this.doses = doses;
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

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    @Override
    public String toString() {
        return "VaccinationAppointment{" +
                "patientEmail='" + patientEmail + '\'' +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", bookingDate=" + bookingDate +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}

