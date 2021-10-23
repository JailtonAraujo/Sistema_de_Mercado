/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.LoginDAO;
import DAO.PedidoDAO;
import DAO.UsuarioDAO;
import MODEL.Pedido;
import MODEL.Usuario;
import VIEW.FrameLogin;
import VIEW.FramePrincipal;
import VIEW.Frame_movimentacao;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author Pichau
 */
public class PrincipalControle {

    private final FramePrincipal view;
    
    
    public PrincipalControle(FramePrincipal view) {
        this.view = view;
    }
    
    
    public void CarregarData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        
        String dt = sdf.format(hoje);
        
        this.view.getLbl_data().setText(dt);
        
    }
    
     public void SetarIcone(){
        this.view.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/Icon_Frame_Main.png")));
    }
    
}
