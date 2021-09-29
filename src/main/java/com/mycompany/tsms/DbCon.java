package com.mycompany.tsms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbCon {
    private Connection con;
    private String url = "jdbc:mysql://localhost:3306/java71";
    private String username = "root";
    private String password = "";
    private String driver = "com.mysql.cj.jdbc.Driver";
    
    public Connection getCon() throws ClassNotFoundException{
        Class.forName(driver);
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
