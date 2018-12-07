// Maqbool Solutions (SMC-Pvt) Ltd.
// https://www.maqboolsolutions.com
// info@maqboolsolutions.com
//
// author: Abid Maqbool
// author-designation: CTO (Chief Technology Officer)
// author-email: cto.ms@outlook.com

package com.maqboolsolutions.mysql_ssh_android;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class FXMLController implements Initializable {

    @FXML
    private TextArea txtOutput;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void btnConnectSSH(ActionEvent event) {
        DBConnection conn = new DBConnection();
        if (conn.getRootConnection()) {
            txtOutput.setText(txtOutput.getText() + "Waiting for connections…\n");
            txtOutput.setText(txtOutput.getText() + "----------------------------------\n");
        }
    }

    @FXML
    private void btnConnectMysql(ActionEvent event) {
        DBConnection conn = new DBConnection();
        if (conn.getConnection() != null) {
            txtOutput.setText(txtOutput.getText() + "Database connection established\n");
            txtOutput.setText(txtOutput.getText() + "DONE...\n");
            txtOutput.setText(txtOutput.getText() + "----------------------------------\n");
        }
    }

    @FXML
    private void btnLoadData(ActionEvent event) {
        SQL sql = new SQL();

        try (ResultSet rs = sql.execQuery("SELECT * FROM users")) {
            while (rs.next()) {
                txtOutput.setText(txtOutput.getText() + rs.getInt("id") + " " + rs.getString("full_name") + " " + rs.getString("email") + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
