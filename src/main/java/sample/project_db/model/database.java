package sample.project_db.model;
import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connectDB() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL mới phù hợp với thông tin DigitalOcean
            // host: db-mysql-nyc3-64236-do-user-21926172-0.f.db.ondigitalocean.com
            String url = "jdbc:postgresql://pg-3e21c264-hustbookstore.h.aivencloud.com:25381/defaultdb";
            String user = "avnadmin";
            String password = "2005";

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
