package sample.project_db.controller.admin;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreenController extends Application{
     @Override
    public void start(Stage primaryStage) {
        // Tạo các trường nhập
        Label titleLabel = new Label("Home page");

        Button adminButton = new Button("Admin");
        Button customerButton = new Button("Customer");

        Label messageLabel = new Label();

        // Xử lý khi nhấn nút đăng ký

        // Tạo layout
        VBox vbox = new VBox(10, titleLabel, messageLabel, adminButton, customerButton);
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


