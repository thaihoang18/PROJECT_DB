package sample.project_db.controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.project_db.utils.hoang.CustomerDAO;
import sample.project_db.model.Customer;

import java.io.IOException;
import java.util.List;

public class CustomerLoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    // Biến tĩnh để lưu customerId
    private static int loggedInCustomerId;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAllCustomers();
        Customer loggedInCustomer = null;

        for (Customer customer : customers) {
            if (customer.getCustomerusername().equals(username) && customer.getCustomerpassword().equals(password)) {
                loggedInCustomer = customer;
                loggedInCustomerId = customer.getCustomerid();
                break;
            }
        }

        if (loggedInCustomer != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/project_db/viewcontroller/OrderHistory.fxml"));
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(new Scene(loader.load(), 800, 500));
                stage.setTitle("Order History");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login failed!");
        }
    }

    // Phương thức để lấy customerId (cho OrderHistoryController sử dụng)
    public static int getLoggedInCustomerId() {
        return loggedInCustomerId;
    }
}