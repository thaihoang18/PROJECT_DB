package sample.project_db;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/home.fxml"));
        Scene scene = new Scene(loader.load(), 400, 300);
        primaryStage.setTitle("Ecommerce App - Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.println(MainApp.class.getResource("/sample/project_db/viewcontroller/home.fxml"));
        launch(args);
    }
}
