package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.util.Navigation;

import java.io.IOException;

public class DashboardFormController {

    @FXML
    private AnchorPane ancDashboard;

    @FXML
    private AnchorPane pagingPane;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnOrder;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "customer_form.fxml");
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnOrderOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "order_form.fxml");
    }

}
