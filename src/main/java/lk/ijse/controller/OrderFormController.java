package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import lk.ijse.util.Navigation;

import java.io.IOException;

public class OrderFormController {

    @FXML
    private Pane pagingPane;

    @FXML
    private JFXButton btnAddNewOrder;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnUpdateOrder;

    @FXML
    private JFXButton btnViewOrder;

    @FXML
    void btnAddNewOrderOnAction(ActionEvent event) {
        try {
            Navigation.switchPaging(pagingPane, "addNewOrder_form.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            Navigation.switchPaging(pagingPane, "dashboard_form.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOrderList(ActionEvent event) {
        try {
            Navigation.switchPaging(pagingPane, "viewOrder_form.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
