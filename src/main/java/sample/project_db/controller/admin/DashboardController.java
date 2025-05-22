package sample.project_db.controller.admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController extends Application {
    public DashboardController() {
        super(); // mặc định
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                DashboardController.class.getResource(
                        "/sample/project_db/viewcontroller/VoucherController.fxml"
                )
        );
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Test thu");
        primaryStage.show();
    }

    public static void main(String[] args) {
    launch(args);}
}