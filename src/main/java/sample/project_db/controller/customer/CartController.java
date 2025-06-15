package sample.project_db.controller.customer;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.project_db.DTO.CartItemDTO;
import sample.project_db.databaseConector.DatabaseConnector;
import sample.project_db.model.Voucher;
import sample.project_db.session.Session;

public class CartController implements Initializable{@FXML private TableView<CartItemDTO> cartTableView;
    @FXML private TableColumn<CartItemDTO, Boolean> selectCol;
    @FXML private TableColumn<CartItemDTO, String> nameCol;
    @FXML private TableColumn<CartItemDTO, Double> priceCol;
    @FXML private TableColumn<CartItemDTO, Integer> quantityCol;
    private ObservableList<CartItemDTO> cartItemDTOs = FXCollections.observableArrayList();

    @FXML private TextField voucherCodeField;
    @FXML private Label cartMessageLabel;
    @FXML private Button handlerConfirmButton;
    @FXML private Button doOrder;

    @FXML
    private void handleOrder(ActionEvent event) {
        String code = voucherCodeField.getText().trim();
        System.out.println(".()");
        int customerId = Session.getCurrentCustomer().getCustomerid();
        System.out.println(".()2");
        float totalprice = 0;
        if (cartItemDTOs.isEmpty()) {
            showAlert("Vui lòng chọn ít nhất một sản phẩm.");
            return;
        }
        System.out.println(".()3");
        for (CartItemDTO elem : cartItemDTOs) {
            totalprice+=elem.getSellprice();
        }
        System.out.println(".()4");
        try {
            System.out.println(".()5");
            Voucher voucher= DatabaseConnector.getVoucherByCode(code);
            System.out.println(".()6");
            DatabaseConnector.setOrder(customerId, totalprice, voucher.getVoucherid());
            System.out.println(".()7");
            DatabaseConnector.setOrderline(cartItemDTOs, customerId);
            showAlert("Đặt hàng thành công!");
            DatabaseConnector.deleteCartItem(customerId, cartItemDTOs);
            System.out.println(".()8");
            
        } catch (SQLException ex) {
            showAlert("Lỗi khi đặt hàng.");

        }
            
        //         // Tính tổng giá
        //         double total = selectedItems.stream()
        //             .mapToDouble(i -> i.getPrice() * i.getQuantity())
        //             .sum();
        //         double finalCost = total - discount;
        
        //         // 1. Insert into orders
        //         PreparedStatement insertOrder = conn.prepareStatement(
        //             "INSERT INTO orders (customerid, totalprice, voucherid) VALUES (?, ?, ?) RETURNING orderid");
        //         insertOrder.setInt(1, customerId);
        //         insertOrder.setDouble(2, finalCost);
        //         if (voucherId != null) {
        //             insertOrder.setInt(3, voucherId);
        //         } else {
        //             insertOrder.setNull(3, java.sql.Types.INTEGER);
        //         }
        
        //         ResultSet rs = insertOrder.executeQuery();
        //         rs.next();
        //         int orderId = rs.getInt("orderid");
        
        //         // 2. Insert into orderline
        //         PreparedStatement insertLine = conn.prepareStatement(
        //             "INSERT INTO orderline (orderid, productid, quantity, pricepurchase) VALUES (?, ?, ?, ?)");
        //         for (CartItemDTO item : selectedItems) {
        //             insertLine.setInt(1, orderId);
        //             insertLine.setInt(2, item.getProductId());
        //             insertLine.setInt(3, item.getQuantity());
        //             insertLine.setDouble(4, item.getPrice());
        //             insertLine.addBatch();
        //         }
        //         insertLine.executeBatch();
        
        //         // 3. Giảm voucher nếu có
        //         if (voucherId != null) {
        //             PreparedStatement updateVoucher = conn.prepareStatement(
        //                 "UPDATE voucher SET remaining = remaining - 1 WHERE voucherid = ?");
        //             updateVoucher.setInt(1, voucherId);
        //             updateVoucher.executeUpdate();
        //         }
        
        //         // 4. Xoá khỏi cartitem
        //         for (CartItemDTO item : selectedItems) {
        //             PreparedStatement del = conn.prepareStatement(
        //                 "DELETE FROM cartitem WHERE customerid = ? AND productid = ?");
        //             del.setInt(1, customerId);
        //             del.setInt(2, item.getProductId());
        //             del.executeUpdate();
        //         }
        
        //         conn.commit();
        //         cartItems.removeAll(selectedItems);
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     }
    }
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Session.setCurrentCustomer(DatabaseConnector.getCustomerByCustomerusername("hung"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("sellprice"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        try {
            cartItemDTOs = DatabaseConnector.loadCartItems();
            for (CartItemDTO elem : cartItemDTOs) {
                System.out.println(".()"+elem.getName());
                
            }
            cartTableView.setItems(cartItemDTOs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
