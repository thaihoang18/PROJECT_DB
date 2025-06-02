package sample.project_db.controller.customer;

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

public class LoginControllerTest {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException{
        System.err.println("");
        System.err.println("");
        System.err.println("");
        System.err.println("");
        String username = usernameField.getText();
        String password = passwordField.getText();
        try {
            if(DatabaseConnector.loginCustomer(username, password)){
                Session.setCurrentCustomer(DatabaseConnector.getCustomerByCustomerusername(username));
                System.err.println("");
                System.err.println("");
                System.err.println("");
                System.err.println("");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/store.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Customer Login");
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
