module sample.project_db {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;
    opens sample.project_db.controller.customer;
exports sample.project_db.controller.customer to javafx.fxml;

    opens sample.project_db.model to javafx.base, javafx.fxml; 
    exports sample.project_db;


    opens sample.project_db to javafx.graphics, javafx.fxml;
    
    opens sample.project_db.controller to javafx.fxml;
    exports sample.project_db.controller;
    
    
    opens sample.project_db.controller.admin to javafx.fxml;
    exports sample.project_db.controller.admin;



}
