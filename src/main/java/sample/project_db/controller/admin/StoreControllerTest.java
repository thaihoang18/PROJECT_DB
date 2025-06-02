package sample.project_db.controller.admin;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.project_db.databaseConector.DatabaseConnector;
import sample.project_db.model.Customer;
import sample.project_db.model.Product;
import sample.project_db.session.Session;

public class StoreControllerTest implements Initializable {

    @FXML private TextField searchStringField;
    @FXML private Button searchButton;
    @FXML private Label messageLabel;
    @FXML private TableView<Product> tableView;

    @FXML private TableColumn<Product, String> nameCol;
    @FXML private TableColumn<Product, Double> priceCol;
    @FXML private TableColumn<Product, Integer> quantityCol;
    @FXML private ComboBox<String> categoryComboBox;
    @FXML private TextField quantityField;
    @FXML private Label cartMessageLabel;



    @FXML
    private void handleAddToCart() {
        Product product = tableView.getSelectionModel().getSelectedItem();
        if (product == null) {
            cartMessageLabel.setText("Vui lòng chọn sản phẩm.");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityField.getText().trim());
            if (quantity <= 0) {
                cartMessageLabel.setText("Số lượng phải lớn hơn 0.");
                return;
            }
        } catch (NumberFormatException e) {
            cartMessageLabel.setText("Số lượng không hợp lệ.");
            return;
        }

        Customer customer = Session.getCurrentCustomer();
        if (customer == null) {
            cartMessageLabel.setText("Bạn chưa đăng nhập.");
            return;
        }

        try {
            System.out.println(".()"+product.getProductid());
            System.out.println(".()"+product.getProductid());
            System.out.println(".()"+product.getProductid());
            System.out.println(".()"+product.getProductid());
            boolean result = DatabaseConnector.addToCart(customer.getCustomerid(), (int)product.getProductid(), quantity);
            if (result) {
                cartMessageLabel.setText("Đã thêm vào giỏ.");
            } else {
                cartMessageLabel.setText("Thêm thất bại.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            cartMessageLabel.setText("Lỗi cơ sở dữ liệu.");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("sellprice"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        try {
            List<Product> products = DatabaseConnector.getAllProducts();
            ObservableList<Product> observableList = FXCollections.observableArrayList(products);
            tableView.setItems(observableList);
            // Load danh sách thể loại
            List<String> categories = DatabaseConnector.getAllCategories(); // bạn cần viết hàm này trong DatabaseConnector
            categoryComboBox.setItems(FXCollections.observableArrayList(categories));
        } catch (SQLException e) {
            e.printStackTrace();
            messageLabel.setText("Lỗi khi tải danh sách sản phẩm.");
        }
    }

    @FXML
    private void handleSearch() {
        String keyword = searchStringField.getText();
        try {
            List<Product> result = DatabaseConnector.getProductsByName(keyword);
            ObservableList<Product> observableResult = FXCollections.observableArrayList(result);
            tableView.setItems(observableResult);
            messageLabel.setText("Tìm thấy " + result.size() + " sản phẩm.");
        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText("Lỗi tìm kiếm.");
        }
    }
    @FXML
    private void handleCategoryFilter() {
        String selectedCategory = categoryComboBox.getValue();
        if (selectedCategory != null && !selectedCategory.isEmpty()) {
            try {
                List<Product> filtered = DatabaseConnector.getProductsByCategory(selectedCategory);
                tableView.setItems(FXCollections.observableArrayList(filtered));
                messageLabel.setText("Tìm thấy " + filtered.size() + " sản phẩm trong thể loại \"" + selectedCategory + "\".");
            } catch (SQLException e) {
                e.printStackTrace();
                messageLabel.setText("Lỗi khi lọc theo thể loại.");
            }
        }
    }

}
