/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Fornecedor;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Jailton
 */
public class FornecedorDAO {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Fornecedor> Fornecedores;

    public boolean CadastrarFornecedor(Fornecedor fornecedor) {
        String slq = "INSERT INTO fornecedor (fornome, forcnpj, fortelefone, forfax, foremail, forsite) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement)conn.prepareStatement(slq);

            pst.setString(1, fornecedor.getNome());
            pst.setString(2, fornecedor.getCNPJ());
            pst.setString(3, fornecedor.getTelefone());
            pst.setString(4, fornecedor.getFax());
            pst.setString(5, fornecedor.getEmail());
            pst.setString(6, fornecedor.getSite());
            pst.execute();

            pst.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar fornecedor:" + ex);
        }

    }

    public ArrayList<Fornecedor> ListarFornecedores() {
        String slq = "SELECT * FROM fornecedor ORDER BY fornome";
        this.Fornecedores = new ArrayList<Fornecedor>();

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(slq);
            rs = pst.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setID(rs.getInt(1));
                fornecedor.setNome(rs.getString(2));
                fornecedor.setCNPJ(rs.getString(3));
                fornecedor.setTelefone(rs.getString(4));
                fornecedor.setFax(rs.getString(5));
                fornecedor.setEmail(rs.getString(6));
                fornecedor.setSite(rs.getString(7));

                this.Fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar fornecedores:" + ex);
        }
        return this.Fornecedores;
    }

    public void ExcluirFornecedor(int index) {
        String sql = "DELETE FROM fornecedor WHERE forcodigo=?";

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setInt(1, index);
            pst.execute();
            pst.close();
            conn.close();
            System.out.println("FORNECEDOR EXCLUIDO COM SUCESSO!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir fornecedor" + ex);
        }
    }

    public boolean AtualizarFornecedor(int index, Fornecedor fornecedor) {
        String sql = "UPDATE fornecedor SET fornome=?, forcnpj=?, fortelefone=?, forfax=?, foremail=?, forsite=? WHERE forcodigo=?";

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, fornecedor.getNome());
            pst.setString(2, fornecedor.getCNPJ());
            pst.setString(3, fornecedor.getTelefone());
            pst.setString(4, fornecedor.getFax());
            pst.setString(5, fornecedor.getEmail());
            pst.setString(6, fornecedor.getSite());
            pst.setInt(7, index);

            pst.execute();
            pst.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            throw new RuntimeException("erro ao atalizar fornecedor:" + ex);
        }

    }

}
