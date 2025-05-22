package sample.project_db.controller.admin;

import java.sql.SQLException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.project_db.databaseConector.DatabaseConnector;
import sample.project_db.model.Product;

public class StoreController extends Application{
    @Override
    public void start(Stage primaryStage) throws SQLException {
        // Tạo các trường nhập
        Label titleLabel = new Label("Store page");
        TextField searchStringField = new TextField();
        searchStringField.setPromptText("Search by name");

        Button searchButton = new Button("Search");

        Label messageLabel = new Label();
        TableView<Product> tableView = new TableView<>();


        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceCol = new TableColumn<>("sellprice");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("sellprice"));

        TableColumn<Product, Integer> quanCol = new TableColumn<>("quantity");
        quanCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        tableView.getColumns().addAll(nameCol, priceCol, quanCol);
        try {
            List<Product> allProducts = DatabaseConnector.getAllProducts();
            System.out.println("Fetched " + allProducts.size() + " products.");
            ObservableList<Product> observableProducts = FXCollections.observableArrayList(allProducts);
            tableView.setItems(observableProducts);
            for (Product p : allProducts) {
                System.out.println(p.getName() + " - " + p.getSellprice() + " - " + p.getQuantity());
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Xử lý khi nhấn nút đăng ký
        searchButton.setOnAction(e -> {
            String searchKey = searchStringField.getText();
            try {
                List<Product> searchProducts = DatabaseConnector.getProductsByName(searchKey);
                ObservableList<Product> observableSearchProducts = FXCollections.observableArrayList(searchProducts);
                tableView.setItems(observableSearchProducts);
            } catch (Exception ex) {
                ex.printStackTrace();
                messageLabel.setText("False  !");
            }
        });
        VBox vbox = new VBox(10, titleLabel, searchStringField,  searchButton, messageLabel, tableView);
        vbox.setPadding(new Insets(20));
        Scene scene = new Scene(vbox, 1400, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}


