package sample.project_db;

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.project_db.model.Admin;


public class LaunchApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private Button admin_btn;

    @FXML
    private StackPane welcomeScreen;

    @FXML
    private Button user_btn;

    public static Admin localAdmin = new Admin();
}