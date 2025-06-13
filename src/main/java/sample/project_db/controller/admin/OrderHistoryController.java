package sample.project_db.controller.admin;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import sample.project_db.model.Order;
import sample.project_db.model.Orderline;
import sample.project_db.utils.hoang.OrderHistoryDAO;
import java.util.List;
import java.text.SimpleDateFormat;

public class OrderHistoryController {

    @FXML
    private TableView<Object> orderTable;
    @FXML
    private TableColumn<Object, Integer> orderIdColumn;
    @FXML
    private TableColumn<Object, Integer> orderlineIdColumn;
    @FXML
    private TableColumn<Object, Integer> productIdColumn;
    @FXML
    private TableColumn<Object, Double> quantityColumn;
    @FXML
    private TableColumn<Object, Double> pricePurchaseColumn;
    @FXML
    private TableColumn<Object, String> purchaseDateColumn;
    @FXML
    private TableColumn<Object, Double> totalPriceColumn;
    @FXML
    private Label totalTransactionsLabel;

    @FXML
    private void initialize() {
        // Cấu hình các cột với lambda expression
        orderIdColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Order) {
                return new ReadOnlyObjectWrapper<>(((Order) cellData.getValue()).getOrderid());
            }
            return null;
        });
        orderlineIdColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Orderline) {
                return new ReadOnlyObjectWrapper<>(((Orderline) cellData.getValue()).getOrderlineid());
            }
            return null;
        });
        productIdColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Orderline) {
                return new ReadOnlyObjectWrapper<>(((Orderline) cellData.getValue()).getProductid());
            }
            return null;
        });
        quantityColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Orderline) {
                return new ReadOnlyObjectWrapper<>(((Orderline) cellData.getValue()).getQuantity());
            }
            return null;
        });
        pricePurchaseColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Orderline) {
                return new ReadOnlyObjectWrapper<>(((Orderline) cellData.getValue()).getPricepurchase());
            }
            return null;
        });
        purchaseDateColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Order) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return new ReadOnlyObjectWrapper<>(sdf.format(((Order) cellData.getValue()).getPurchasedate()));
            }
            return null;
        });
        totalPriceColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Order) {
                return new ReadOnlyObjectWrapper<>(((Order) cellData.getValue()).getTotalprice());
            }
            return null;
        });

        // Lấy dữ liệu từ DAO
        OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
        int customerId = CustomerLoginController.getLoggedInCustomerId(); // Sửa lại tên Controller
        List<Object> orderHistory = orderHistoryDAO.getOrderHistoryByCustomerId(customerId);
        ObservableList<Object> observableOrderHistory = FXCollections.observableArrayList(orderHistory);
        orderTable.setItems(observableOrderHistory);

        // Hiển thị tổng số lần giao dịch
        int totalTransactions = orderHistoryDAO.getTotalTransactions(customerId);
        totalTransactionsLabel.setText("Total Transactions: " + totalTransactions);
    }
}