package sample.project_db.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class SidebarController {
    @FXML
    private StackPane contentPane;

    private void loadPage(String fxmlFile) {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/sample/project_db/viewcontroller/"+fxmlFile));
            System.out.println(getClass().getResource("/sample/project_db/viewcontroller/" + fxmlFile));
            System.out.println(getClass().getResource("/sample/project_db/viewcontroller/" + fxmlFile));
            System.out.println(getClass().getResource("/sample/project_db/viewcontroller/" + fxmlFile));

            
            System.out.println("contentPane = " + pane);
            System.out.println("contentPane = " + pane);
            contentPane.getChildren().setAll(pane);

            // Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            // primaryStage.setScene(scene);
            // primaryStage.setTitle("Test thu");
            // primaryStage.show();
            System.out.println("contentPane = " + contentPane);
            System.out.println("contentPane = " + contentPane);
            System.out.println("contentPane = " + contentPane);
            System.out.println("contentPane = " + contentPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleDashboard() {
        loadPage("Dashboard.fxml");
    }

    public void handleInventory() {
        loadPage("Inventory.fxml");
    }

    public void handleMenu() {
        loadPage("Menu.fxml");
    }
    public void handleStore() {
        loadPage("store.fxml");
    }

    public void handleCustomers() {
        loadPage("Customers.fxml");
    }

    public void handleSignOut() {
        // Quay về login hoặc thoát
    }


}
