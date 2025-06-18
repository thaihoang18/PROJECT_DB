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

import java.text.SimpleDateFormat;
import java.util.List;

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
            Orderline orderline = findFirstOrderlineForOrder(cellData.getValue());
            return orderline != null ? new ReadOnlyObjectWrapper<>(orderline.getOrderlineid()) : null;
        });
        productIdColumn.setCellValueFactory(cellData -> {
            Orderline orderline = findFirstOrderlineForOrder(cellData.getValue());
            return orderline != null ? new ReadOnlyObjectWrapper<>(orderline.getProductid()) : null;
        });
        quantityColumn.setCellValueFactory(cellData -> {
            Orderline orderline = findFirstOrderlineForOrder(cellData.getValue());
            return orderline != null ? new ReadOnlyObjectWrapper<>(orderline.getQuantity()) : null;
        });
        pricePurchaseColumn.setCellValueFactory(cellData -> {
            Orderline orderline = findFirstOrderlineForOrder(cellData.getValue());
            return orderline != null ? new ReadOnlyObjectWrapper<>(orderline.getPricepurchase()) : null;
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
        int customerId = CustomerLoginController.getLoggedInCustomerId();
        List<Object> orderHistory = orderHistoryDAO.getOrderHistoryByCustomerId(customerId);
        ObservableList<Object> observableOrderHistory = FXCollections.observableArrayList(orderHistory);

        // Lọc bỏ các phần tử không cần thiết (nếu có)
        ObservableList<Object> filteredOrderHistory = FXCollections.observableArrayList();
        for (Object item : observableOrderHistory) {
            if (item instanceof Order || (item instanceof Orderline && !filteredOrderHistory.isEmpty() && filteredOrderHistory.get(filteredOrderHistory.size() - 1) instanceof Order)) {
                filteredOrderHistory.add(item);
            }
        }

        // Đảm bảo dữ liệu được gán đúng
        if (filteredOrderHistory.isEmpty()) {
            System.out.println("No order history found for customer ID: " + customerId);
        }
        orderTable.setItems(filteredOrderHistory);

        // Hiển thị tổng số lần giao dịch
        int totalTransactions = orderHistoryDAO.getTotalTransactions(customerId);
        totalTransactionsLabel.setText("Total Transactions: " + totalTransactions);
    }

    private Orderline findFirstOrderlineForOrder(Object item) {
        if (item instanceof Order) {
            int orderId = ((Order) item).getOrderid();
            // Tìm Orderline đầu tiên trong danh sách orderHistory
            for (Object obj : orderTable.getItems()) {
                if (obj instanceof Orderline) {
                    Orderline orderline = (Orderline) obj;
                    if (orderline.getOrderid() == orderId) {
                        return orderline;
                    }
                }
            }
        }
        return null;
    }
}