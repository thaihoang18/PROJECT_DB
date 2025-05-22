package sample.project_db.databaseConector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sample.project_db.model.Customer;
import sample.project_db.model.Product;

public class DatabaseConnector {

    private static final String URL = "jdbc:postgresql://pg-3e21c264-hustbookstore.h.aivencloud.com:25381/defaultdb";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_ZHQAYXiiXVHd8_NdUAl";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void registerUser(String customerusername, String customerpassword, String question, String answer, String customername, String phonenumber, String email, String address) throws SQLException {
        String sql = "INSERT INTO customer (customerusername, customerpassword, question, answer, customername, phonenumber, email, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerusername);
            stmt.setString(2, customerpassword);
            stmt.setString(3, question);
            stmt.setString(4, answer);
            stmt.setString(5, customername);
            stmt.setString(6, phonenumber);
            stmt.setString(7, email);
            stmt.setString(8, address);
            stmt.executeUpdate();
        }
    }
    public static boolean  loginUser(String customerusername, String customerpassword) throws SQLException {
        String sql = "SELECT customerusername, customerpassword FROM customer WHERE customerusername =? AND customerpassword =?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerusername);
            stmt.setString(2, customerpassword);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();
        }
    }
    public static Customer getCustomerByCustomerusername(String customerusername) throws SQLException {
        String sql = "SELECT * FROM customer WHERE customerusername =?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerusername);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                return new Customer(resultSet.getInt("customerid"), resultSet.getString("customerusername"), resultSet.getString("customerpassword"), resultSet.getString("question"), resultSet.getString("answer"), resultSet.getString("customername"), resultSet.getString("phonenumber"), resultSet.getString("email"), resultSet.getString("address"));
            } else{
                return  null;
            }
        }
    }
    public static List<Product> getAllProducts() throws SQLException {
        String sql = "SELECT * FROM product";
        List<Product> allProduct = new ArrayList<>();
        try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                allProduct.add(new Product(
                    resultSet.getString("name"),
                    resultSet.getInt("quantity"),
                    resultSet.getDouble("sellprice")
                ));
            } 
            return allProduct;
        }
    }

}
