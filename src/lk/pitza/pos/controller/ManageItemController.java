/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.math.BigDecimal;
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
import lk.pitza.pos.business.custom.ItemBO;
import lk.pitza.pos.business.custom.impl.ItemBOImpl;
import lk.pitza.pos.dto.ItemDTO;
import lk.pitza.pos.main.AppInitializer;
import lk.pitza.pos.view.util.tblmodel.ItemTM;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FXML Controller class
 *
 * @author Maheshwarie
 */
public class ManageItemController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtItemId;
    @FXML
    private JFXTextField txtItemName;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtPrice;
    @FXML
    private TableView<ItemTM> tblItems;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private ImageView imgpizzaMain;
    
    private boolean decide = false;
    /**
     * Initializes the controller class.
     */
    @Autowired
     private ItemBO itemBO;
    public ManageItemController(){
        itemBO = AppInitializer.ctx.getBean(ItemBO.class);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("I_Id"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("It_name"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Description"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Price"));
        LoadAllItems();
   
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
    private void btnAddOnAction(ActionEvent event) {
        decide = true;
           txtItemId.setText("");
           txtItemName.setText("");
           txtDescription.setText("");
           txtPrice.setText("");
           tblItems.getSelectionModel().clearSelection();
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        if(decide == true && !(tblItems.getSelectionModel().getSelectedIndex()>=0) ){
            saveItem();
            LoadAllItems();
        }else if(tblItems.getSelectionModel().getSelectedIndex()>=0 && decide ==false){
            updateItem();
            LoadAllItems();
        }
        else{
            new Alert(Alert.AlertType.WARNING, "Please press the Add new Button to add Item..", ButtonType.OK).show();
        }
    }

    @FXML
    private void btnSearchOnAction(ActionEvent event) {
             String I_Id = txtItemId.getText();
        try {
            ItemDTO item = itemBO.findByID(I_Id);
            txtItemName.setText(item.getIt_name());
            txtDescription.setText(item.getDescription());
            txtPrice.setText(String.valueOf(item.getPrice()));
        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveItem() {
        try {
            String I_Id = txtItemId.getText();
            String It_name = txtItemName.getText();
            
            BigDecimal Price =  new BigDecimal(txtPrice.getText());
            String Description = txtDescription.getText();
            ItemDTO itemDTO = new ItemDTO(I_Id, It_name, Description, Price);
            
            Boolean result = itemBO.saveItem(itemDTO);
            if(result){
                new Alert(Alert.AlertType.INFORMATION, "Item has been saved successfully", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.INFORMATION, "Error on saving Item", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LoadAllItems() {
         try {
            ArrayList<ItemDTO> allItems = itemBO.getAllItem();
            ArrayList<ItemTM> addItems = new ArrayList<>();
            for (ItemDTO items : allItems) {
                ItemTM item = new ItemTM(items.getI_Id(), items.getIt_name(), items.getDescription(), items.getPrice());
             
                addItems.add(item);
            }
            tblItems.setItems(FXCollections.observableArrayList(addItems));
            
        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        if(tblItems.getSelectionModel().getSelectedIndex()>=0){
            deleteCustomer();
            LoadAllItems();
        }else{
            new Alert(Alert.AlertType.ERROR, "Please select a Item to delete..", ButtonType.OK).show();
        }
    }

    private void deleteCustomer() {
         ItemTM item = tblItems.getSelectionModel().getSelectedItem();
       String I_Id = item.getI_Id();
        try {
            boolean result = itemBO.deleteItem(I_Id);
            if(result){
                new Alert(Alert.AlertType.INFORMATION, "Item has been deleted successfully..", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.INFORMATION, "Error when deleting Item..", ButtonType.OK).show();
            }
                    
        } catch (Exception ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    

    
    
}
