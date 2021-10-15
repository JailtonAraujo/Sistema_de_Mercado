/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Usuario;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;




/**
 *
 * @author Pichau
 */
public class LoginDAO {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public static int Id = 0;
    
    public Usuario Logar(Usuario logado){
        String sql = "SELECT usulogin, ususenha, ususetor, usucodigo FROM usuario WHERE usulogin like '%"+logado.getLogin()+"%'"
                + " and ususenha like '%"+logado.getSenha()+"%'and ususetor like '%"+logado.getDivisao()+"%'"; 
        
        Usuario usuario = new Usuario();
        
        try{
            
            conn = new ConectionFactory().getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
                
            rs.next();
            usuario.setLogin(rs.getString("usulogin"));
            Id = rs.getInt("usucodigo");
            usuario.setSenha(rs.getString("ususenha"));
            usuario.setDivisao(rs.getString("ususetor"));
            
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro:"+ex);
            
        }
        return usuario;
    }
    
    public int ReturnUsu(){   
        return Id;
    
    
    }
    
}
