package sample.project_db;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fXMLloader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/home.fxml"));
        Parent parent = fXMLloader.load();

        stage.setTitle("Bookstore App");
        stage.setScene(new Scene(parent, 800, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
