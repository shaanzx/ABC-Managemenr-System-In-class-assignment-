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
import javafx.beans.property.SimpleStringProperty;
import lk.ijse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static lk.ijse.db.Array.order;

public class ViewOrderFormController implements Initializable {

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<String[], String> colCusId;

    @FXML
    private TableColumn<String[], String> colDescription;

    @FXML
    private TableColumn<String[], String> colOrderId;

    @FXML
    private TableColumn<String[], String> colQty;

    @FXML
    private TableColumn<String[], String> colUnitPrice;

    @FXML
    private Pane pagingPane;

    @FXML
    private TableView<String[]> tblOrder;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            Navigation.switchPaging(pagingPane, "dashboard_form.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllOrders();
    }

    private void setCellValueFactory() {
        colOrderId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0]));
        colCusId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1]));
        colDescription.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[2]));
        colQty.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[3]));
        colUnitPrice.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[4]));
    }

    private void loadAllOrders() {
        ObservableList<String[]> orderList = FXCollections.observableArrayList();
        for (String[] orderData : order) {
            orderList.add(orderData);
        }
        tblOrder.setItems(orderList);
    }
}
