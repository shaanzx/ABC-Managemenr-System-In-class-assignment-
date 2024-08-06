package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import lk.ijse.util.Navigation;

import java.io.IOException;

import static lk.ijse.db.Array.customer;

public class AddNewCustomerFormController {

    @FXML
    private Pane pagingPane;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerCID;

    @FXML
    private TextField txtCustomerContact;

    @FXML
    private TextField txtCustomerName;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "customer_form.fxml");
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String cusCID = txtCustomerCID.getText();
        String cusName = txtCustomerName.getText();
        String cusTel = txtCustomerContact.getText();
        String cusAddress = txtCustomerAddress.getText();
        if (cusCID.isEmpty() || cusName.isEmpty() || cusTel.isEmpty() || cusAddress.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"All fields must be filled out.").show();
            return;
        }
        String[][] temp = new String[customer.length + 1][4];
        int i;
        for (i = 0; i < customer.length; i++) {
            temp[i] = customer[i];
        }
        temp[customer.length] = new String[]{cusCID, cusName, cusTel, cusAddress};
        customer = temp;

        txtCustomerCID.clear();
        txtCustomerName.clear();
        txtCustomerContact.clear();
        txtCustomerAddress.clear();

        new Alert(Alert.AlertType.INFORMATION,"Customer added successfully!").show();
    }
}
