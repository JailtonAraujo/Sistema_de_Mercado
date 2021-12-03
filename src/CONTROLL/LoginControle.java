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
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        new Thread() {
            public void run() {
                while (true) {
                

                    ConectionFactory conn = new ConectionFactory();
                    if (conn.getConnection() != null) {
                        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/IconBDconectado.png"));
                        view.getLbl_Icone().setIcon(icon);
                    } else {
                        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/IconBDerror.png"));
                        view.getLbl_Icone().setIcon(icon);
                    }
                    
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LoginControle.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        }.start();

        /*ConectionFactory conn = new ConectionFactory();
        if (conn.getConnection() != null) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/IconBDconectado.png"));
            this.view.getLbl_Icone().setIcon(icon);
        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/IconBDerror.png"));
            this.view.getLbl_Icone().setIcon(icon);
        }*/
    }

    //METODO QUE SERA CHAMADO NO ATO DO LOGIN E FARÁ A VERIFICAÇÃO E APLICARÁ AS RESTRÇÕES DE ACESSO AO USUARIOS DO DIFERENRES SETORES//
    public void restricao(FramePrincipal frame) {
        if ("CAIXA".equals(this.view.getBox_UsuDivisao().getSelectedItem())) {
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

    public void SetarIcone() {
        this.view.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/Icon_Frame_Main.png")));
    }
}
