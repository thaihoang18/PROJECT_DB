package sample.project_db.controller.admin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.project_db.databaseConector.DatabaseConnector;

public class RegisterController extends Application {
    

    @Override
    public void start(Stage primaryStage) {
        // Tạo các trường nhập
        Label titleLabel = new Label("Đăng ký tài khoản");
        TextField customerusernameField = new TextField();
        customerusernameField.setPromptText("Username");
        TextField customernameField = new TextField();
        customernameField.setPromptText("Name");
        TextField phonenumberField = new TextField();
        phonenumberField.setPromptText("Phonenumber");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        TextField addressField = new TextField();
        addressField.setPromptText("Address");

        PasswordField customerpaswordField = new PasswordField();
        customerpaswordField.setPromptText("Password");

        TextField questionField = new TextField();
        questionField.setPromptText("Question");
        TextField answerField = new TextField();
        answerField.setPromptText("Answer");

        Button registerButton = new Button("Đăng ký");

        Label messageLabel = new Label();

        // Xử lý khi nhấn nút đăng ký
        registerButton.setOnAction(e -> {
            String customerusername = customerusernameField.getText();
            String customerpassword = customerpaswordField.getText();
            String question = answerField.getText();
            String answer = answerField.getText();
            String customername = customernameField.getText();
            String phonenumber = phonenumberField.getText();
            String email = emailField.getText();
            String address = addressField.getText();

            if (customerusername.isEmpty() || customerpassword.isEmpty() || answer.isEmpty()|| question.isEmpty()|| customername.isEmpty()|| phonenumber.isEmpty()|| email.isEmpty()|| address.isEmpty()) {
                messageLabel.setText("Vui lòng điền đầy đủ thông tin.");
            } else {
                try {
                    DatabaseConnector.registerUser(customerusername, customerpassword, question, answer, customername, phonenumber, email, address);
                    messageLabel.setText("Đăng ký thành công!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    messageLabel.setText("Lỗi khi đăng ký!");
                }
            }
});

        // Tạo layout
        VBox vbox = new VBox(10, titleLabel, customerusernameField, customerpaswordField, questionField, answerField, customernameField, phonenumberField, emailField, addressField, registerButton, messageLabel);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Form Đăng Ký");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

