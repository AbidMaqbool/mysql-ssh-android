// Maqbool Solutions (SMC-Pvt) Ltd.
// https://www.maqboolsolutions.com
// info@maqboolsolutions.com
//
// author: Abid Maqbool
// author-designation: CTO (Chief Technology Officer)
// author-email: cto.ms@outlook.com
                
package com.maqboolsolutions.mysql_ssh_android;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQL {

    DBConnection con = new DBConnection();

    public ResultSet execQuery(String query) {
        ResultSet rs = null;
        try {
            rs = this.con.getConnection().createStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
}
