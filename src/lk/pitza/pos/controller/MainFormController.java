/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kulunu Chamath
 */
public class MainFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgcust;
    @FXML
    private ImageView imgItem;
    @FXML
    private ImageView imgOrder;
    @FXML
    private ImageView imgEmp;
    @FXML
    private ImageView imgPlaceOrder;
    @FXML
    private ImageView imgReport;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {
    }

    @FXML
    private void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;
            switch (icon.getId()) {
                case "imgcust":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/pitza/pos/view/ManageCustomer.fxml"));
                    break;
                case "imgItem":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/pitza/pos/view/ManageItem.fxml"));
                    break;
                case "imgOrder":
                    //root = FXMLLoader.load(this.getClass().getResource("/lk/pitza/pos/view/ManageCustomer.fxml"));
                    break;

                case "imgEmp":
                    //root = FXMLLoader.load(this.getClass().getResource("/lk/pitza/pos/view/ManageCustomer.fxml"));
                    break;

                case "imgPlaceOrder":
                    //root = FXMLLoader.load(this.getClass().getResource("/lk/pitza/pos/view/ManageCustomer.fxml"));
                    break;

                case "imgReport":
                    //root = FXMLLoader.load(this.getClass().getResource("/lk/pitza/pos/view/ManageCustomer.fxml"));
                    break;
            }
            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }

        }
    }

}
