package com.example.covid_management_app.model_classes;

import java.io.*;
import java.time.LocalDate;

public class Vaccination implements Serializable {
    private int id;
    private int vaccineId;
    private LocalDate dateAdministered;
    private String administeredBy, patientEmail;
    private int doseNumber;

    public Vaccination(int id, int vaccineId, LocalDate dateAdministered, String administeredBy, String patientEmail,
            int doseNumber) {
        this.id = id;
        this.vaccineId = vaccineId;
        this.dateAdministered = dateAdministered;
        this.administeredBy = administeredBy;
        this.doseNumber = doseNumber;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public LocalDate getDateAdministered() {
        return dateAdministered;
    }

    public void setDateAdministered(LocalDate dateAdministered) {
        this.dateAdministered = dateAdministered;
    }

    public String getAdministeredBy() {
        return administeredBy;
    }

    public void setAdministeredBy(String administeredBy) {
        this.administeredBy = administeredBy;
    }

    public int getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(int doseNumber) {
        this.doseNumber = doseNumber;
    }

    public static int generateVaccinationId() {
        int lastVaccinationId = 0;
        try {
            File file = new File("Vaccinations.bin");
            if (!file.exists()) {
                return 1;
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Vaccination lastVaccination;
            try {
                while (true) {
                    lastVaccination = (Vaccination) ois.readObject();
                    lastVaccinationId = lastVaccination.getId();
                }
            } catch (EOFException e) {
                // Expected when reaching the end of the file
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastVaccinationId + 1;
    }
}
