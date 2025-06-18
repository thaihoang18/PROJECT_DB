package sample.project_db.utils.hoang;

import sample.project_db.model.Order;
import sample.project_db.model.Orderline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHistoryDAO {
    private static final String DB_URL = "jdbc:postgresql://pg-3e21c264-hustbookstore.h.aivencloud.com:25381/defaultdb";
    private static final String DB_USER = "avnadmin";
    private static final String DB_PASSWORD = "AVNS_ZHQAYXiiXVHd8_NdUAl";

    public List<Object> getOrderHistoryByCustomerId(int customerId) {
        List<Object> orderHistory = new ArrayList<>();
        Map<Integer, Order> orderMap = new HashMap<>();

        String sql = "SELECT o.orderid, o.purchasedate, o.totalprice, ol.orderlineid, ol.productid, ol.quantity, ol.pricepurchase " +
                     "FROM orders o " +
                     "LEFT JOIN orderline ol ON o.orderid = ol.orderid " +
                     "WHERE o.customerid = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int orderId = rs.getInt("orderid");
                    if (!orderMap.containsKey(orderId)) {
                        Order order = new Order(
                            customerId,
                            orderId,
                            rs.getDate("purchasedate"),
                            rs.getDouble("totalprice")
                        );
                        orderMap.put(orderId, order);
                        orderHistory.add(order); // Thêm Order duy nhất
                    }
                    // Thêm Orderline nếu có (sử dụng LEFT JOIN, có thể NULL)
                    if (rs.getObject("orderlineid") != null) {
                        Orderline orderline = new Orderline(
                            orderId,
                            rs.getInt("orderlineid"),
                            rs.getDouble("pricepurchase"),
                            rs.getInt("productid"),
                            rs.getDouble("quantity")
                        );
                        if (orderHistory.size() <= orderMap.size() || !(orderHistory.get(orderHistory.size() - 1) instanceof Orderline)) {
                            orderHistory.add(orderline);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Debug: In ra số lượng orderid duy nhất được xử lý
        System.out.println("Number of unique orderids processed: " + orderMap.size());

        return orderHistory;
    }

    public int getTotalTransactions(int customerId) {
        String sql = "SELECT COUNT(DISTINCT orderid) FROM orders WHERE customerid = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    System.out.println("Distinct orderid count from DB: " + count);
                    return count;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}