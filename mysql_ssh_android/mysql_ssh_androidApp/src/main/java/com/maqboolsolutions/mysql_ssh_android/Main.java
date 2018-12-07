// Maqbool Solutions (SMC-Pvt) Ltd.
// https://www.maqboolsolutions.com
// info@maqboolsolutions.com
//
// author: Abid Maqbool
// author-designation: CTO (Chief Technology Officer)
// author-email: cto.ms@outlook.com

package com.maqboolsolutions.mysql_ssh_android;

import com.gluonhq.charm.down.Platform;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXML.fxml"));
        
        Scene scene;
        if (Platform.isAndroid()) {
            Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
            scene = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight());
        } else {
            scene = new Scene(root);
        }
        
        primaryStage.setTitle("Mysql connect over SSH!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest((event) -> {
            System.exit(0);
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
