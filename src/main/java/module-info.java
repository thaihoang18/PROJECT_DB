module sample.project_db {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens sample.project_db.model to javafx.base, javafx.fxml; 

    exports sample.project_db;
    opens sample.project_db to javafx.graphics, javafx.fxml;
    opens sample.project_db.controller.admin to javafx.fxml;

    exports sample.project_db.controller.admin;



}
