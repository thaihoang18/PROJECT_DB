module sample.project_db {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.project_db to javafx.fxml;
    exports sample.project_db;
}