module sample.project_db {
    // JavaFX modules
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    // Java SQL and PostgreSQL
    requires java.sql;
    requires org.postgresql.jdbc;

    // Exports
    exports sample.project_db;
    exports sample.project_db.controller;
    exports sample.project_db.controller.customer;
    exports sample.project_db.controller.admin;
    exports sample.project_db.utils.hoang;

    // Opens
    opens sample.project_db to javafx.graphics, javafx.fxml;
    opens sample.project_db.model to javafx.base, javafx.fxml;
    opens sample.project_db.DTO to javafx.base;
    opens sample.project_db.controller to javafx.fxml;
    opens sample.project_db.controller.customer to javafx.fxml;
    opens sample.project_db.controller.admin to javafx.fxml;
    opens sample.project_db.utils.hoang to javafx.graphics;
}
