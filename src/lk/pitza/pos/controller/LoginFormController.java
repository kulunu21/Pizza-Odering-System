/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Maheshwarie
 */
public class LoginFormController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPassword;
    @FXML
    private JFXButton btnLog;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnLogOnActon(ActionEvent event) throws IOException {
        if (txtUser.getText().equals("admin") && txtPassword.getText().equals("admin")){
            
            Parent root = null;
            
            root = FXMLLoader.load(this.getClass().getResource("/lk/pitza/pos/view/MainForm.fxml"));
            
            if (root!=null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                
                TranslateTransition t = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                t.setFromX(-subScene.getWidth());
                t.setToX(0);
                t.play();
            }
            
        }else{
            new Alert(Alert.AlertType.ERROR, "UserName Or Password Incorrect").show();
        }
    }
    
}
