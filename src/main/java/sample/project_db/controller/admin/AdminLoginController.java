package sample.project_db.controller.admin;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.project_db.databaseConector.DatabaseConnector;
import sample.project_db.session.Session;

public class AdminLoginController extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Tạo các trường nhập
        Label titleLabel = new Label("Admin login page");
        TextField customerusernameField = new TextField();
        customerusernameField.setPromptText("Username");
        
        PasswordField customerpaswordField = new PasswordField();
        customerpaswordField.setPromptText("Password");

        Button registerButton = new Button("Login");

        Label messageLabel = new Label();

        // Xử lý khi nhấn nút đăng ký
        registerButton.setOnAction(e -> {
            String customerusername = customerusernameField.getText();
            String customerpassword = customerpaswordField.getText();
           
            if (customerusername.isEmpty() || customerpassword.isEmpty()) {
                messageLabel.setText("Vui lòng điền đầy đủ thông tin.");
            } else {
                try {
                    if(DatabaseConnector.loginUser(customerusername, customerpassword)){
                        messageLabel.setText("Login successfull!");
                        Session.setCurrentAdmin(DatabaseConnector.getadminByadminusername(customerusername));
                    } else{
                        messageLabel.setText("username or password is false");
                    }
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                    messageLabel.setText("False Login !");
                }
            }
});

        // Tạo layout
        VBox vbox = new VBox(10, titleLabel, customerusernameField, customerpaswordField,  registerButton, messageLabel);
        vbox.setPadding(new Insets(20));
        Scene scene = new Scene(vbox, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Form Login");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
