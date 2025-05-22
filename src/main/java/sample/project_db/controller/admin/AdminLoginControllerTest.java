package sample.project_db.controller.admin;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.project_db.databaseConector.DatabaseConnector;
import sample.project_db.session.Session;

public class AdminLoginControllerTest {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException{
        String username = usernameField.getText();
        String password = passwordField.getText();
        try {
            if(DatabaseConnector.loginUser(username, password)){
                Session.setCurrentAdmin(DatabaseConnector.getadminByadminusername(username));
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/store.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Admin Login");
                stage.show();
                showAlert(Alert.AlertType.INFORMATION, "Đăng nhập thành công!");
            } else{
                showAlert(Alert.AlertType.ERROR, "Sai tên đăng nhập hoặc mật khẩu.");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
