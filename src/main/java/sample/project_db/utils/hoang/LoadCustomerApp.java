package sample.project_db.utils.hoang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadCustomerApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoadCustomerApp.class.getResource("/sample/project_db/viewcontroller/LoadCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        primaryStage.setTitle("Customer List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}