package sample.project_db.controller.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sample.project_db.databaseConector.DatabaseConnector;

public class test {
    public static void main(String[] args) {
        
        String sql = "select * from admin";
        try (Connection connection = DatabaseConnector.connect(); PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            System.out.println(resultSet.getString("adminusername"));
        } catch (Exception e) {
        }
    }



}
