package sample.project_db.controller.customer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.project_db.databaseConector.DatabaseConnector;

public class SignupController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField nameField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private TextField questionField;
    @FXML private TextField answerField;
    @FXML private TextField addressField;

    @FXML
    private void handleSignup() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String question = questionField.getText().trim();
        String answer = answerField.getText().trim();
        String address = addressField.getText().trim();

        if (username.isEmpty() || password.isEmpty() || question.isEmpty() || answer.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Vui lòng điền đầy đủ thông tin bắt buộc.");
            return;
        }

        boolean success = DatabaseConnector.registerCustomer(username, password, question, answer, username, phone, email, address);
        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Đăng ký thành công!");
            clearFields();
        } else {
            showAlert(Alert.AlertType.ERROR, "Tên đăng nhập đã tồn tại hoặc có lỗi khi đăng ký.");
        }
    }

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
        nameField.clear();
        phoneField.clear();
        emailField.clear();
        questionField.clear();
        answerField.clear();
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
