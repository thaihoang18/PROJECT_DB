module sample.project_db {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;
    requires org.postgresql.jdbc;

    
    exports sample.project_db.utils.hoang to javafx.graphics;

    opens sample.project_db.utils.hoang to javafx.graphics;

    opens sample.project_db.controller.admin to javafx.fxml;
    exports sample.project_db.controller.admin to javafx.fxml;

 
    opens sample.project_db.model to javafx.base, javafx.fxml;
}