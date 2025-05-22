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

public class AdminRegisterController extends Application {
    

    @Override
    public void start(Stage primaryStage) {
        // Tạo các trường nhập
        Label titleLabel = new Label("Admin register");
        TextField adminusernameField = new TextField();
        adminusernameField.setPromptText("Username");
        TextField adminnameField = new TextField();
        adminnameField.setPromptText("Name");
        TextField phonenumberField = new TextField();
        phonenumberField.setPromptText("Phonenumber");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField adminpaswordField = new PasswordField();
        adminpaswordField.setPromptText("Password");

        TextField questionField = new TextField();
        questionField.setPromptText("Question");
        TextField answerField = new TextField();
        answerField.setPromptText("Answer");

        Button registerButton = new Button("Đăng ký");

        Label messageLabel = new Label();

        // Xử lý khi nhấn nút đăng ký
        registerButton.setOnAction(e -> {
            String adminusername = adminusernameField.getText();
            String adminpassword = adminpaswordField.getText();
            String question = answerField.getText();
            String answer = answerField.getText();
            String adminname = adminnameField.getText();
            String phonenumber = phonenumberField.getText();
            String email = emailField.getText();

            if (adminusername.isEmpty() || adminpassword.isEmpty() || answer.isEmpty()|| question.isEmpty()|| adminname.isEmpty()|| phonenumber.isEmpty()|| email.isEmpty()) {
                messageLabel.setText("Vui lòng điền đầy đủ thông tin.");
            } else {
                try {
                    DatabaseConnector.registerAdmin(adminusername, adminpassword, question, answer, adminname, phonenumber, email);
                    messageLabel.setText("Đăng ký thành công!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    messageLabel.setText("Lỗi khi đăng ký!");
                }
            }
});

        // Tạo layout
        VBox vbox = new VBox(10, titleLabel, adminusernameField, adminpaswordField, questionField, answerField, adminnameField, phonenumberField, emailField, registerButton, messageLabel);
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

