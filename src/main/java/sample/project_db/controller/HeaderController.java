package sample.project_db.controller;


import javafx.fxml.FXML;

public class HeaderController {
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void goHome() {
        if (mainController != null) {
            mainController.setContent("/sample/project_db/viewcontroller/home.fxml");
        }
    }

    @FXML
    private void goProfile() {
        if (mainController != null) {
            mainController.setContent("/sample/project_db/viewcontroller/profile.fxml");
        }
    }
    @FXML
    private void goLogin() {
        if (mainController != null) {
            mainController.setContent("/sample/project_db/viewcontroller/login.fxml");
        }
    }
    @FXML
    private void goStore() {
        if (mainController != null) {
            mainController.setContent("/sample/project_db/viewcontroller/store.fxml");
        }
    }
    @FXML
    private void goSignup() {
        if (mainController != null) {
            mainController.setContent("/sample/project_db/viewcontroller/signup.fxml");
        }
    }
}

