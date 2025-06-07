package sample.project_db.controller.admin;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.project_db.DTO.RevenueDTO;
import sample.project_db.databaseConector.DatabaseConnector;

public class MonthlyRevenueController implements Initializable {
    @FXML
    private TableView<RevenueDTO> tableView;
    @FXML 
    private TableColumn<RevenueDTO, String> monthCol;
    @FXML 
    private TableColumn<RevenueDTO, Double> revenueCol;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        monthCol.setCellValueFactory(new PropertyValueFactory<>("month"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        
        try {
            List<RevenueDTO> revenueDTOs = DatabaseConnector.getMonthlyRevenue();
            ObservableList<RevenueDTO> observableList = FXCollections.observableArrayList(revenueDTOs);
            tableView.setItems(observableList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
