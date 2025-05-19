module sample.project_db {
    requires javafx.controls;
    requires javafx.fxml;

    opens sample.project_db to javafx.graphics, javafx.fxml;
    opens sample.project_db.controller.admin to javafx.fxml;

    exports sample.project_db;
    exports sample.project_db.controller.admin;


    requires java.sql;

}
