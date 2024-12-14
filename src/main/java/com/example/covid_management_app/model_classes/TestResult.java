package com.example.covid_management_app.model_classes;

import java.io.*;

public class TestResult implements Serializable {
    private int id;
    private String patientEmail;
    private String testDate;
    private String result;
    private String comments;

    public TestResult(int id, String patientEmail, String testDate, String result, String comments) {
        this.id = id;
        this.patientEmail = patientEmail;
        this.testDate = testDate;
        this.result = result;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private static int lastTestId = 0;

    public static int generateTestId() {
        try {
            File file = new File("TestResult.bin");
            if (!file.exists()) {
                return 1;
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            TestResult lastTestResult;
            try {
                while (true) {
                    lastTestResult = (TestResult) ois.readObject();
                    lastTestId = lastTestResult.getId();
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
        return lastTestId + 1;
    }

}
