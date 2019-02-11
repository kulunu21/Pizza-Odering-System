/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Kulunu Chamath
 */

public class AppInitializer extends Application {

    public static AnnotationConfigApplicationContext ctx;


    
    @Override
    public void start(Stage primaryStage) {

        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

           try {

            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/pitza/pos/view/LoginForm.fxml"));

            Scene mainScene = new Scene(root);

            primaryStage.setTitle("The Pizza Cental:World famous pizza shop");
            primaryStage.setScene(mainScene);
            primaryStage.setResizable(false);
            
            primaryStage.show();
           

        } catch (IOException ex) {
            Logger.getLogger(AppInitializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(AppInitializer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void navigateToHome(Node node, Stage mainStage) {

    
            TranslateTransition tt = new TranslateTransition(Duration.millis(300), node);
            tt.setFromX(0);
            tt.setToX(-node.getScene().getWidth());
            tt.play();
            
            Platform.runLater(()->{
            
                try {
                    Parent root = FXMLLoader.load(AppInitializer.class.getResource("/lk/pitza/pos/view/MainForm.fxml"));
                    Scene mainScene = new Scene(root);
                    mainStage.setScene(mainScene);
                    
                    TranslateTransition tt1 = new TranslateTransition(Duration.millis(300), root.lookup("AnchorPane"));
                    tt1.setToX(0);
                    tt1.setFromX(-mainScene.getWidth());
                    tt1.play();
                    
                    mainStage.centerOnScreen();
                } catch (IOException ex) {
                    Logger.getLogger(AppInitializer.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            });
            
  

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
