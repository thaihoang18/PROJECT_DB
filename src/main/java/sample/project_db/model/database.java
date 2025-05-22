package sample.project_db.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connectDB() {
        try {
            // Đổi sang driver của PostgreSQL
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://pg-3e21c264-hustbookstore.h.aivencloud.com:25381/defaultdb";
            String user = "avnadmin";
            String password = "AVNS_ZHQAYXiiXVHd8_NdUAl";

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}