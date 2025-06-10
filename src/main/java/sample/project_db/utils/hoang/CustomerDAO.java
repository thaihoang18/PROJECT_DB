package sample.project_db.utils.hoang;

import sample.project_db.model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO {
    private static final String DB_URL = "jdbc:postgresql://pg-3e21c264-hustbookstore.h.aivencloud.com:25381/defaultdb";
    private static final String DB_USER = "avnadmin";
    private static final String DB_PASSWORD = "AVNS_ZHQAYXiiXVHd8_NdUAl";

    // Hàm lấy danh sách tất cả khách hàng
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerid(rs.getInt("customerid"));
                customer.setCustomerusername(rs.getString("customerusername"));
                customer.setCustomerpassword(rs.getString("customerpassword"));
                customer.setQuestion(rs.getString("question"));
                customer.setAnswer(rs.getString("answer"));
                customer.setCustomername(rs.getString("customername"));
                customer.setPhonenumber(rs.getString("phonenumber"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // Hàm lấy số lần mua hàng cho từng customerid
    public Map<Integer, Integer> getPurchaseCounts() {
        Map<Integer, Integer> purchaseCounts = new HashMap<>();
        String countSql = "SELECT customerid, COUNT(*) as purchase_count FROM orders GROUP BY customerid";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(countSql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                purchaseCounts.put(rs.getInt("customerid"), rs.getInt("purchase_count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseCounts;
    }
}