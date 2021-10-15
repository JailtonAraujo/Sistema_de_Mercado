/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.ConectionFactory;
import DAO.LoginDAO;
import MODEL.Usuario;
import VIEW.FrameLogin;
import VIEW.FramePrincipal;
import javax.swing.ImageIcon;

/**
 *
 * @author Pichau
 */
public class LoginControle {

    private final FrameLogin view;
    private final LoginDAO dao;

    public LoginControle(FrameLogin view) {
        this.view = view;
        this.dao = new LoginDAO();
    }

    public boolean logar() {
        Usuario modelo = this.ObterModelo();
        this.dao.Logar(modelo);
        Usuario logado = this.dao.Logar(modelo);
        if ((modelo.getLogin().equals(logado.getLogin()) && (modelo.getSenha().equals(logado.getSenha())) && (modelo.getDivisao().equals(logado.getDivisao())))) {
            return true;
        }
        return false;
    }

    //#METODO QUE OBTEM AS INFORMAÇÕES PASSADAS NOS CAMPOS DA VIEW DE LOGIN#//
    public Usuario ObterModelo() {
        String login = this.view.getTex_UsuLogin().getText();
        String senha = this.view.getTex_UsuSenha().getText();
        String divisao = this.view.getBox_UsuDivisao().getSelectedItem().toString();

        Usuario modelo = new Usuario(login, senha, divisao);
        return modelo;

    }

    public boolean VerificarDivisao() {
        Usuario modelo = this.ObterModelo();
        this.dao.Logar(modelo);
        Usuario logado = this.dao.Logar(modelo);
        if ((modelo.getLogin().equals(logado.getLogin()) && (modelo.getSenha().equals(logado.getSenha())) && ("ADMINISTRADOR".equals(logado.getDivisao())))) {
            return true;
        }
        return false;
    }

    //#METODO QEU CARREGA A IMAGEM DE CONCETIVIDADE COM BANCO DE DADOS NA TELA DE LOGIN BASEADO NO STATUS DA CONEXÃO#//
    public void CarregarImg() {
        ConectionFactory conn = new ConectionFactory();
        if (conn.getConnection() != null) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/IconBDconectado.png"));
            this.view.getLbl_Icone().setIcon(icon);
        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/IconBDerror.png"));
            this.view.getLbl_Icone().setIcon(icon);
        }
    }

    
    public void restricao(FramePrincipal frame){
        if ("CAIXA".equals(this.view.getBox_UsuDivisao().getSelectedItem())){
            frame.getBtn_mov().setEnabled(false);
            frame.getBtn_produtos().setEnabled(false);
            frame.getBnt_Fornecedor().setEnabled(false);
            frame.getBnt_Clientes().setEnabled(false);
            frame.getMenu_Usuarios().setEnabled(false);
            frame.getMenu_Fornecedores().setEnabled(false);
            frame.getMenu_Clientes().setEnabled(false);
            frame.getMenu_Produtos().setEnabled(false);
            frame.getMenu_Financas().setEnabled(false);
        }
        
    }
}
