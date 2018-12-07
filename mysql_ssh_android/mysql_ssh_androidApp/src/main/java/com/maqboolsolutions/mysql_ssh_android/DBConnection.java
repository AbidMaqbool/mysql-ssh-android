// Maqbool Solutions (SMC-Pvt) Ltd.
// https://www.maqboolsolutions.com
// info@maqboolsolutions.com
//
// author: Abid Maqbool
// author-designation: CTO (Chief Technology Officer)
// author-email: cto.ms@outlook.com

package com.maqboolsolutions.mysql_ssh_android;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.maqboolsolutions.mysql_ssh_android.DbContract.DB_URL;
import static com.maqboolsolutions.mysql_ssh_android.DbContract.DRIVER;
import static com.maqboolsolutions.mysql_ssh_android.DbContract.PASSWORD;
import static com.maqboolsolutions.mysql_ssh_android.DbContract.PORT;
import static com.maqboolsolutions.mysql_ssh_android.DbContract.USERNAME;

public class DBConnection {

    Connection con = null;
    Session session = null;

    //Fields
    String rHost = ""; //hosting provider (example.com)
    String user = ""; //remote host user name (b123)
    String password = ""; //remote host password (123)

    int rPort = 3306; //remote mysql database port

    public Connection getConnection() {
        try {
            //mysql database connectivity
            Class.forName(DRIVER);

            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            System.out.println("Database connection established");
            System.out.println("DONE");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public boolean getRootConnection() {
        close();

        try {
            //Create the JSCH object
            JSch jsch = new JSch();

            //Get the session
            session = jsch.getSession(user, rHost);

            //Set the password
            session.setPassword(password);

            //To be able to connect to any host (this is just for testing!)
            session.setConfig("StrictHostKeyChecking", "no");

            //Connect the session
            session.connect();

            //Set port forward
            session.setPortForwardingL(PORT, "localhost", rPort);

            //Show message
            System.out.println("Waiting for connections…");

            return true;
        } catch (JSchException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void close() {
        try {
            if (con != null && !con.isClosed()) {
                System.out.println("Closing Database Connection");
                con.close();
            }
            if (session != null && session.isConnected()) {
                System.out.println("Closing SSH Connection");
                session.disconnect();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
