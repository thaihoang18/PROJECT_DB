package sample.project_db.utils.hoang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderHistoryApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OrderHistoryApp.class.getResource("/sample/project_db/viewcontroller/CustomerLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        primaryStage.setTitle("Customer Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}