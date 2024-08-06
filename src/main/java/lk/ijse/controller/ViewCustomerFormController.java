package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import lk.ijse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static lk.ijse.db.Array.customer;

public class ViewCustomerFormController implements Initializable {

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<String[], String> colAddress;

    @FXML
    private TableColumn<String[], String> colId;

    @FXML
    private TableColumn<String[], String> colName;

    @FXML
    private TableColumn<String[], String> colTel;

    @FXML
    private Pane pagingPane;

    @FXML
    private TableView<String[]> tblCustomer;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            Navigation.switchPaging(pagingPane, "customer_form.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadCustomerData();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[0]));
        colName.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[1]));
        colTel.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[2]));
        colAddress.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[3]));
    }

    private void loadCustomerData() {
        ObservableList<String[]> customerList = FXCollections.observableArrayList();

        for (String[] customerData : customer) {
            customerList.add(customerData);
        }

        tblCustomer.setItems(customerList);
    }
}
