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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.project_db.databaseConector.DatabaseConnector;
import sample.project_db.model.Product;

public class StoreControllerTest implements Initializable {

    @FXML private TextField searchStringField;
    @FXML private Button searchButton;
    @FXML private Label messageLabel;
    @FXML private TableView<Product> tableView;

    @FXML private TableColumn<Product, String> nameCol;
    @FXML private TableColumn<Product, Double> priceCol;
    @FXML private TableColumn<Product, Integer> quantityCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("sellprice"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        try {
            List<Product> products = DatabaseConnector.getAllProducts();
            ObservableList<Product> observableList = FXCollections.observableArrayList(products);
            tableView.setItems(observableList);
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
}
