// Maqbool Solutions (SMC-Pvt) Ltd.
// https://www.maqboolsolutions.com
// info@maqboolsolutions.com
//
// author: Abid Maqbool
// author-designation: CTO (Chief Technology Officer)
// author-email: cto.ms@outlook.com

package com.maqboolsolutions.mysql_ssh_android;

public interface DbContract {

    public static final Integer PORT = 53009;

    public static final String DB_NAME = ""; //database name (db_test)
    public static final String DB_URL = "jdbc:mysql://localhost:" + PORT + "/" + DB_NAME;
    public static final String USERNAME = ""; //mysql database user name (admin)
    public static final String PASSWORD = ""; //mysql database password (12345)

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
}
