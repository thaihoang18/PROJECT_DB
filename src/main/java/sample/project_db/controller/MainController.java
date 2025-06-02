package sample.project_db.controller;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private StackPane stackPane;
    // @FXML
    // public void handleAdminLogin(ActionEvent event) throws IOException {
    //     FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/admin_login.fxml"));
    //     Scene scene = new Scene(loader.load());
    //     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     stage.setScene(scene);
    //     stage.setTitle("Admin Login");
    //     stage.show();
    // }

    // @FXML
    // public void handleCustomerLogin(ActionEvent event) throws IOException {
    //     FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/customer_login.fxml"));
    //     Scene scene = new Scene(loader.load());
    //     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     stage.setScene(scene);
    //     stage.setTitle("Customer Login");
    //     stage.show();
    // }
    @FXML
    public void initialize() {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/header.fxml"));
            Node node = fXMLLoader.load();
            HeaderController headerController = fXMLLoader.getController();
            headerController.setMainController(this);
            borderPane.setLeft(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setContent(String fxmlFile) {
        try {
            System.out.println(".()");
            System.out.println(".()");
            System.out.println(".()");
            System.out.println(".()");
            System.out.println(".()");
            System.out.println(".()");
            System.out.println(".()");
            System.out.println(".()");
            Node view = FXMLLoader.load(getClass().getResource(fxmlFile));
            stackPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
