/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class ConectionFactory {
    
    public static Connection getConnection(){
        
        Connection conn = null;
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/siscontrole?useSSL=false";
        String user = "root";
        String password = "";
        
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);
            return conn;
        
        }catch(Exception ex){
            ex.printStackTrace();
            
            return null;
        }
    
    }
}
