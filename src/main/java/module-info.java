module com.example.covid_management_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires jdk.incubator.vector;


    opens com.example.covid_management_app to javafx.fxml;
    exports com.example.covid_management_app;
    opens com.example.covid_management_app.model_classes to javafx.base;
}