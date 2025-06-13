package sample.project_db.utils.hoang;

import sample.project_db.model.Order;
import sample.project_db.model.Orderline;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryDAO {
	  private static final String DB_URL = "jdbc:postgresql://pg-3e21c264-hustbookstore.h.aivencloud.com:25381/defaultdb";
	  private static final String DB_USER = "avnadmin";
	  private static final String DB_PASSWORD = "AVNS_ZHQAYXiiXVHd8_NdUAl";

    public List<Object> getOrderHistoryByCustomerId(int customerId) {
        List<Object> orderHistory = new ArrayList<>();
        String sql = "SELECT o.orderid, o.purchasedate, o.totalprice, ol.orderlineid, ol.productid, ol.quantity, ol.pricepurchase " +
                     "FROM orders o " +
                     "JOIN orderline ol ON o.orderid = ol.orderid " +
                     "WHERE o.customerid = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Order order = new Order(
                        customerId,
                        rs.getInt("orderid"),
                        rs.getDate("purchasedate"),
                        rs.getDouble("totalprice")
                    );
                    Orderline orderline = new Orderline(
                        rs.getInt("orderid"),
                        rs.getInt("orderlineid"),
                        rs.getDouble("pricepurchase"),
                        rs.getInt("productid"),
                        rs.getDouble("quantity")
                    );
                    orderHistory.add(order);
                    orderHistory.add(orderline);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderHistory;
    }

    public int getTotalTransactions(int customerId) {
        String sql = "SELECT COUNT(*) FROM orders WHERE customerid = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}