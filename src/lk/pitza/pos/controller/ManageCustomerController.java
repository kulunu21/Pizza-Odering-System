/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.pitza.pos.business.custom.CustomerBO;
import lk.pitza.pos.business.custom.impl.CustomerBOImpl;
import lk.pitza.pos.dto.CustomerDTO;
import lk.pitza.pos.main.AppInitializer;
import lk.pitza.pos.view.util.tblmodel.CustomerTM;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FXML Controller class
 *
 * @author Maheshwarie
 */
public class ManageCustomerController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgpizzaMain;
    @FXML
    private JFXTextField txtCustID;
    @FXML
    private JFXTextField txtCustName;
    @FXML
    private JFXTextField txtCustContact;
    @FXML
    private JFXTextField txtCustAddress;
    @FXML
    private TableView<CustomerTM> tblCustomer;
    @FXML
    private JFXButton btnSaveCust;
    @FXML
    private JFXButton btnNewCust;
    @FXML
    private JFXButton btnDelCust;

    private boolean decide = false;

    /**
     * Initializes the controller class.
     */

    private CustomerBO customerBO;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnUpdateCust1;

    public ManageCustomerController(){
        customerBO = AppInitializer.ctx.getBean(CustomerBO.class);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("C_Id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("C_name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Address"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Contact"));
        LoadAllCustomers();
        // TODO
    }

    @FXML
    private void navigateToHome(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView img = (ImageView) event.getSource();
            Parent root = null;
            switch (img.getId()) {
                case "imgpizzaMain":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/pitza/pos/view/MainForm.fxml"));
                    break;

            }
            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                primaryStage.show();
                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }

        }
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        if (decide) {
            saveCustomer();
            LoadAllCustomers();
        } else if (tblCustomer.getSelectionModel().getSelectedIndex() >= 0 && decide == false) {
            updateCustomer();
            LoadAllCustomers();
        } else {
            new Alert(Alert.AlertType.WARNING, "Please press the Add new Button to add Customer..", ButtonType.OK).show();
        }
    }

    @FXML
    private void btnAddNewOnAction(ActionEvent event) {
        decide = true;
        txtCustID.setText("");
        txtCustName.setText("");
        txtCustAddress.setText("");
        txtCustContact.setText("");
        tblCustomer.getSelectionModel().clearSelection();
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        if (tblCustomer.getSelectionModel().getSelectedIndex() >= 0) {
            deleteCustomer();
            LoadAllCustomers();
        } else {
            new Alert(Alert.AlertType.ERROR, "Please select a customer to Delete..", ButtonType.OK).show();
        }
    }

    private void LoadAllCustomers() {
        try {
            ArrayList<CustomerDTO> AllCustomers = customerBO.getAllCustomer();
            ArrayList<CustomerTM> addCustomers = new ArrayList<>();
            for (CustomerDTO AllCustomer : AllCustomers) {
                CustomerTM customer = new CustomerTM(AllCustomer.getC_Id(), AllCustomer.getC_name(), AllCustomer.getAddress(), AllCustomer.getContact());
                addCustomers.add(customer);
            }
            tblCustomer.setItems(FXCollections.observableArrayList(addCustomers));

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnSearchOnAction(ActionEvent event) {
        String C_Id = txtCustID.getText();
        try {
            CustomerDTO customer = customerBO.findByID(C_Id);
            txtCustName.setText(customer.getC_name());
            txtCustAddress.setText(customer.getAddress());
            txtCustContact.setText(String.valueOf(customer.getContact()));
        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveCustomer() {
        String C_Id = txtCustID.getText();
        String C_name = txtCustName.getText();
        String Address = txtCustAddress.getText();
        int Contact = Integer.valueOf(txtCustContact.getText());
        CustomerDTO customer = new CustomerDTO(C_Id, C_name, Address, Contact);

        try {
            Boolean result = customerBO.saveCustomer(customer);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Customer saved successfully", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Error on saving customer", ButtonType.OK).show();
            }

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void deleteCustomer() {
        CustomerTM customer = tblCustomer.getSelectionModel().getSelectedItem();
        String C_Id = customer.getC_Id();
        try {
            boolean result = customerBO.deleteCustomer(C_Id);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Customer has been deleted successfully..", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Error when deleting customer..", ButtonType.OK).show();
            }

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
        String C_Id = txtCustID.getText();
        String C_name = txtCustName.getText();
        String Address = txtCustAddress.getText();
        int Contact = Integer.valueOf(txtCustContact.getText());
        CustomerDTO customer = new CustomerDTO(C_Id, C_name, Address, Contact);

        try {
            Boolean result = customerBO.updateCusomer(customer);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Update successfully", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Error on Updating customer", ButtonType.OK).show();
            }

        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updateCustomer() {

        CustomerTM selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();
        String C_Id = selectedCustomer.getC_Id();
        String C_name = txtCustName.getText();
        String Address = txtCustAddress.getText();
        int Contact = Integer.parseInt(txtCustContact.getText());
        CustomerDTO customer = new CustomerDTO(C_Id, C_name, Address, Contact);

        try {
            Boolean result = customerBO.updateCusomer(customer);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Item has been Updated successfully..", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Error on update Item...", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
