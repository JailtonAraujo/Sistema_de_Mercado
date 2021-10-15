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
public class UsuarioDAO {

  
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private ArrayList<Usuario> usuarios;

    public boolean CadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (usunome, usulogin, ususenha, ususetor) VALUES (?, ?, ?, ?);";

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getDivisao());
            pst.execute();
            pst.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar usuario:" + ex);
        }
    }

    public ArrayList<Usuario> ListarUsuario() {
        String sql = "SELECT * FROM usuario ORDER BY usunome;";
        this.usuarios = new ArrayList<Usuario>();

        try {

            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNome(rs.getString(2));
                usuario.setLogin(rs.getString(3));
                usuario.setSenha(rs.getString(4));
                usuario.setDivisao(rs.getString(5));
                this.usuarios.add(usuario);
            }
            pst.close();
            conn.close();
            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar usuarios:" + ex);
        }
        return usuarios;
    }

    public void EscluirUsuario(int index) {
        String sql = "DELETE FROM usuario WHERE usucodigo = ?;";

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setInt(1, index);
            pst.execute();
            pst.close();
            conn.close();
            System.out.println("Usuario " + index + " foi excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Não foi possivel excluir o usuario selecinado:" + ex);
        }
    }

    public boolean AtualizarUsuario(int index, Usuario usuario) {
        String sql = "UPDATE usuario SET usunome=?, usulogin=?, ususenha=?, ususetor=? WHERE usucodigo=?;";

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getDivisao());
            pst.setInt(5, index);
            pst.execute();
            pst.close();
            conn.close();
            System.out.println("USUARIO ATUALIZADO COM SUCESSO");
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO AO ATUALIZAR USUARIO:" + ex);
            throw new RuntimeException(ex);
        }
    }

    public String BuscarUsuario(int Id) {
        String sql = "SELECT usunome FROM usuario WHERE usucodigo = ?";
        String NomeUsuario = null;

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setInt(1, Id);
            rs = pst.executeQuery();
            rs.next();

            NomeUsuario = rs.getString(1);

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar usuario" + ex);
        }
        return NomeUsuario;

    }
}
