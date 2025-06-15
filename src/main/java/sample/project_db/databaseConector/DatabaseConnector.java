package sample.project_db.databaseConector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.project_db.DTO.CartItemDTO;
import sample.project_db.DTO.RevenueDTO;
import sample.project_db.model.Admin;
import sample.project_db.model.Customer;
import sample.project_db.model.Product;
import sample.project_db.model.Voucher;
import sample.project_db.session.Session;

public class DatabaseConnector {

    private static final String URL = "jdbc:postgresql://pg-3e21c264-hustbookstore.h.aivencloud.com:25381/defaultdb";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_ZHQAYXiiXVHd8_NdUAl";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static boolean  registerCustomer(String customerusername, String customerpassword, String question, String answer, String customername, String phonenumber, String email, String address)  {
        String sql = "";

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
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

public static boolean registerAdmin(String username, String password, String question, String answer) {
    String sql = "  SELECT admin_signup " +
                 "(?, ?, ?, ?)";

    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, question);
        preparedStatement.setString(4, answer);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return (boolean)resultSet.getBoolean(1);

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public static boolean  loginCustomer(String customerusername, String customerpassword) throws SQLException {
        String sql = "SELECT customerusername, customerpassword FROM customer WHERE customerusername =? AND customerpassword =?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerusername);
            stmt.setString(2, customerpassword);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();
        }
    }
    public static boolean  loginAdmin(String adminusername, String adminpassword) throws SQLException {
        String sql = "SELECT admin_login(?,?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, adminusername);
            stmt.setString(2, adminpassword);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();

            return (boolean)resultSet.getBoolean(1);
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
    public static Admin getadminByadminusername(String adminusername) throws SQLException {
        String sql = "SELECT * FROM admin WHERE adminusername =?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, adminusername);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                return new Admin(resultSet.getInt("adminid"),
                        resultSet.getString("adminusername"),
                        resultSet.getString("adminpassword"),
                        resultSet.getString("question"),
                        resultSet.getString("answer"),
                        resultSet.getString("adminname"),
                        resultSet.getString("phonenumber"),
                        resultSet.getString("email"));
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
                    allProduct.add(mapProduct(resultSet));
            } 
            return allProduct;
        }
    }
    public static List<Product> getProductsByName(String searchKey) throws SQLException {
        String sql = "SELECT * FROM product WHERE name ILIKE ?";
        List<Product> allProduct = new ArrayList<>();
        try (Connection conn = connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, "%"+ searchKey+"%");
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                allProduct.add(mapProduct(resultSet));
            } 
            return allProduct;
        }
    }
    public static List<String> getAllCategories() throws SQLException {
        List<String> categories = new ArrayList<>();
        String query = "SELECT categoryname FROM category";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                categories.add(rs.getString("categoryname"));
            }
        }
        return categories;
    }


    public static List<Product> getProductsByCategory(String category) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "select * from find_by_category(?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(mapProduct(rs)); // Hàm mapProduct để chuyển từ ResultSet sang Product
            }
        }
        return products;
    }
    private static Product mapProduct(ResultSet rs) throws SQLException {
    Product p = new Product();
    System.out.println(".()cccccccccccc"+rs.getInt("productid"));
    System.out.println(".()cccccccccccc"+rs.getInt("productid"));
    System.out.println(".()cccccccccccc"+rs.getInt("productid"));
    System.out.println(".()cccccccccccc"+rs.getInt("productid"));
    System.out.println(".()cccccccccccc"+rs.getInt("productid"));
    System.out.println(".()cccccccccccc"+rs.getInt("productid"));
    p.setProductid(rs.getInt("productid"));
    // p.setType(rs.getString("type"));
    p.setName(rs.getString("name"));
    p.setDistributor(rs.getString("distributor"));
    p.setDesscription(rs.getString("description"));
    p.setAddeddate(rs.getDate("addeddate") != null ? rs.getDate("addeddate").toLocalDate() : null);
    p.setQuantity(rs.getInt("quantity"));
    p.setImportprice(rs.getDouble("importprice"));
    p.setSellprice(rs.getDouble("sellprice"));
    p.setAge(rs.getInt("age"));
    p.setIsbn(rs.getString("isbn"));
    p.setAuthor(rs.getString("author"));
    // p.setGenre(rs.getString("genre"));
    p.setPublishdate(rs.getDate("publishdate") != null ? rs.getDate("publishdate").toLocalDate() : null);
    p.setCategoryid(rs.getInt("categoryid"));
    return p;
}
public static boolean addToCart(int customerId, int productId, int quantity) throws SQLException {
    Connection conn = connect();    
    // 2. Kiểm tra sản phẩm đã có trong cart chưa
    String checkItemSql = "SELECT cartitemid, quantity FROM cartitem WHERE customerid = ? AND productid = ?";
    PreparedStatement checkStmt = conn.prepareStatement(checkItemSql);
    checkStmt.setInt(1, customerId);
    checkStmt.setInt(2, productId);
    ResultSet itemRs = checkStmt.executeQuery();

    if (itemRs.next()) {
        // Cập nhật số lượng
        int newQuantity = itemRs.getInt("quantity") + quantity;
        String updateSql = "UPDATE cartitem SET quantity = ? WHERE customerid = ? AND productid = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateSql);
        updateStmt.setInt(1, newQuantity);
        updateStmt.setInt(2, customerId);
        updateStmt.setInt(3, productId);
        updateStmt.executeUpdate();
    } else {
        // Thêm mới
        String insertSql = "INSERT INTO cartitem (customerid, productid, quantity) VALUES (?, ?, ?)";
        PreparedStatement insertStmt = conn.prepareStatement(insertSql);
        insertStmt.setInt(1, customerId);
        insertStmt.setInt(2, productId);
        insertStmt.setInt(3, quantity);
        insertStmt.executeUpdate();
    }

    return true;
}
public static List<RevenueDTO> getMonthlyRevenue() throws SQLException{
    List<RevenueDTO> monthlyRevenue = new ArrayList<>();
    Connection connection = connect();
    String sql = "select * from get_monthly_revenue()";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
        RevenueDTO revenueDTO = new RevenueDTO();
        revenueDTO.setMonth(resultSet.getString("month"));
        revenueDTO.setRevenue(resultSet.getDouble(("revenue")));
        monthlyRevenue.add(revenueDTO);
    }
    return  monthlyRevenue;
}

public static ObservableList<CartItemDTO> loadCartItems() throws SQLException {
    ObservableList<CartItemDTO> list = FXCollections.observableArrayList();

    int customerId = Session.getCurrentCustomer().getCustomerid();
    String query = "SELECT p.productid, p.name, p.sellprice, ci.quantity " +
                   "FROM cartitem ci " +
                   "JOIN product p ON ci.productid = p.productid " +
                   "WHERE ci.customerid = ?";

    try (Connection conn = DatabaseConnector.connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, customerId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            list.add(new CartItemDTO(
                rs.getInt("productid"),
                rs.getString("name"),
                rs.getInt("quantity"),
                rs.getDouble("sellprice")
            ));
        }
    }
    return list;
    }
    public static Voucher getVoucherByCode( String code) throws SQLException {
        System.out.println(".()"+code);
        String query = "SELECT * FROM voucher WHERE code = ? AND remaining > 0 AND duration >= CURRENT_DATE";
        try (Connection conn = DatabaseConnector.connect();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            System.out.println(".()1321546");
            Voucher voucher = new Voucher(
                    rs.getString("code"),
                    rs.getInt("remaining"),
                    rs.getFloat("discount"),
                    rs.getDate("duration").toLocalDate(),
                    rs.getInt("voucherid")
                );
                System.out.println(".()1321546");
        
                return voucher;
            }
    }
        public static int setOrder(int customerid, float  totalprice, int voucherid) {
        String sql = "INSERT INTO orders (customerid, totalprice, voucherid) VALUES (?, ?, ?) RETURNING orderid";

        try (Connection conn = connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, customerid);
            preparedStatement.setFloat( 2, totalprice);
            preparedStatement.setInt(3, voucherid);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return (int)resultSet.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
        public static boolean  setOrderline(List<CartItemDTO> cartItemDTOs, int orderId) {
        String sql = "INSERT INTO orderline (orderid, productid, quantity, pricepurchase) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect()){
            PreparedStatement insertLine = conn.prepareStatement(
                "INSERT INTO orderline (orderid, productid, quantity, pricepurchase) VALUES (?, ?, ?, ?)");
            for (CartItemDTO item : cartItemDTOs) {
                insertLine.setInt(1, orderId);
                insertLine.setInt(2, item.getProductid());
                insertLine.setInt(3, item.getQuantity());
                insertLine.setDouble(4, item.getSellprice());
                insertLine.addBatch();
            }
            insertLine.executeBatch();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        public static boolean  deleteCartItem(int customerid, List<CartItemDTO> cartItemDTOs) {
        String sql = "INSERT INTO orderline (orderid, productid, quantity, pricepurchase) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect()){
            PreparedStatement insertLine = conn.prepareStatement(
                "INSERT INTO orderline (orderid, productid, quantity, pricepurchase) VALUES (?, ?, ?, ?)");
                for (CartItemDTO item : cartItemDTOs) {
                PreparedStatement del = conn.prepareStatement(
                    "DELETE FROM cartitem WHERE customerid = ? AND productid = ?");
                del.setInt(1, customerid);
                del.setInt(2, item.getProductid());
                del.executeUpdate();
            }
            insertLine.executeBatch();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
