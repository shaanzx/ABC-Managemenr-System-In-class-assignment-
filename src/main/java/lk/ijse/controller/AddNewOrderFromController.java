package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import lk.ijse.util.Navigation;

import java.io.IOException;
import java.util.Optional;

import static lk.ijse.db.Array.order;

public class AddNewOrderFromController {
    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnOrderSave;

    @FXML
    private Pane pagingPane;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            Navigation.switchPaging(pagingPane, "order_form.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnOrderSaveOnAction(ActionEvent event) {
        String orderId = txtOrderId.getText();
        String customerId = txtCustomerId.getText();
        String description = txtDescription.getText();
        String qty = txtQty.getText();
        String unitPrice = txtUnitPrice.getText();

        if (orderId.isEmpty() || customerId.isEmpty() || description.isEmpty() || qty.isEmpty() || unitPrice.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"All fields must be filled out.").show();
            return;
        }

        String[] newOrder = {orderId, customerId, description, qty, unitPrice};

        String[][] temp = new String[order.length + 1][5];
        for (int i = 0; i < order.length; i++) {
            temp[i] = order[i];
        }
        temp[order.length] = newOrder;
        order = temp;

        txtOrderId.clear();
        txtCustomerId.clear();
        txtDescription.clear();
        txtQty.clear();
        txtUnitPrice.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order saved successfully!");
        alert.showAndWait();

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to place another order?");
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText("Do you want to place another order?");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
        } else {
            try {
                Navigation.switchPaging(pagingPane, "dashboard_form.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
