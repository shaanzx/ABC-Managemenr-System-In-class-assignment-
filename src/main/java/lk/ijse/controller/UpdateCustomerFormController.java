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

public class UpdateCustomerFormController {

    @FXML
    private Pane pagingPane;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

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
    void btnDeleteOnAction(ActionEvent event) {
        String customerId = txtCustomerCID.getText();
        boolean found = false;
        int indexToRemove = -1;

        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0].equals(customerId)) {
                indexToRemove = i;
                found = true;
                break;
            }
        }

        if (found) {
            String[][] temp = new String[customer.length - 1][4];
            int tempIndex = 0;
            for (int i = 0; i < customer.length; i++) {
                if (i != indexToRemove) {
                    temp[tempIndex++] = customer[i];
                }
            }
            customer = temp;

            txtCustomerCID.clear();
            txtCustomerName.clear();
            txtCustomerContact.clear();
            txtCustomerAddress.clear();

            new Alert(Alert.AlertType.INFORMATION,"Customer deleted successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Customer ID not found.").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String customerId = txtCustomerCID.getText();
        String newCustomerName = txtCustomerName.getText();
        String newCustomerContact = txtCustomerContact.getText();
        String newCustomerAddress = txtCustomerAddress.getText();

        boolean found = false;

        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0].equals(customerId)) {
                customer[i][1] = newCustomerName;
                customer[i][2] = newCustomerContact;
                customer[i][3] = newCustomerAddress;
                found = true;
                break;
            }
        }

        if (found) {
            new Alert(Alert.AlertType.INFORMATION,"Customer details updated successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Customer ID not found.").show();
        }
    }

    @FXML
    void txtCustomerCIDOnAction(ActionEvent event) {

        String customerId = txtCustomerCID.getText();
        boolean found = false;

        for (String[] customerData : customer) {

            if (customerData[0].equals(customerId)) {
                txtCustomerName.setText(customerData[1]);
                txtCustomerContact.setText(customerData[2]);
                txtCustomerAddress.setText(customerData[3]);
                found = true;
                break;
            }
        }

        if (!found) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Customer ID not found.");
            alert.showAndWait();

            txtCustomerName.clear();
            txtCustomerContact.clear();
            txtCustomerAddress.clear();
        }
    }
}
