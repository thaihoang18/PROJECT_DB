package sample.project_db.controller.admin;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.project_db.model.Customer;
import sample.project_db.utils.hoang.CustomerDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadCustomerController {

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, String> emailColumn;

    @FXML
    private TableColumn<Customer, String> addressColumn;

    @FXML
    private TableColumn<Customer, Integer> purchaseCountColumn;

    @FXML
    private void initialize() {
        // Liên kết các cột với thuộc tính của lớp Customer
        idColumn.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("customername"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        // Lấy danh sách khách hàng từ CustomerDAO
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = customerDAO.getAllCustomers();

        // Lấy số lần mua hàng từ DAO
        Map<Integer, Integer> purchaseCounts = customerDAO.getPurchaseCounts();

        // Cấu hình cột purchaseCount với lambda expression
        purchaseCountColumn.setCellValueFactory(cellData -> {
            int customerId = cellData.getValue().getCustomerid();
            return new ReadOnlyObjectWrapper<>(purchaseCounts.getOrDefault(customerId, 0));
        });

        // Chuyển đổi danh sách thành ObservableList để hiển thị trên TableView
        ObservableList<Customer> observableCustomers = FXCollections.observableArrayList(customerList);

        // Gán danh sách cho TableView
        customerTable.setItems(observableCustomers);
    }
}