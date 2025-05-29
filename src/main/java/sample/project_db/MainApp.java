package sample.project_db;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
   @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/home.fxml"));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/admin_login.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
