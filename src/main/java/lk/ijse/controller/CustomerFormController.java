package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.util.Navigation;

import java.io.IOException;

public class CustomerFormController {

    @FXML
    private Pane pagingPane;

    @FXML
    private JFXButton btnAddNewCustomer;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnUpdateCustomer;

    @FXML
    private JFXButton btnViewCustomer;

    @FXML
    void btnAddNewCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "addNewCustomer_form.fxml");

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "dashboard_form.fxml");
    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "updateCustomer_form.fxml");
    }

    @FXML
    void btnViewCustomerList(ActionEvent event) {;
        try {
            Navigation.switchPaging(pagingPane, "viewCustomerTable.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
