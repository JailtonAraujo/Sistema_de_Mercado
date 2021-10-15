/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Cliente;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Pichau
 */
public class ClienteDAO {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Cliente> Clientes;

    public boolean CadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (clinome, clicpf, clitelefone, cliemail, "
                + "clicep, clilogadouro, clinumero, clicomplemento, clibairro, climunicipio, cliestado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCPF());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEmail());
            pst.setString(5, cliente.getCEP());
            pst.setString(6, cliente.getLogradouro());
            pst.setString(7, cliente.getNumero());
            pst.setString(8, cliente.getComplemento());
            pst.setString(9, cliente.getBairro());
            pst.setString(10, cliente.getCidade());
            pst.setString(11, cliente.getEstado());
            pst.execute();
            pst.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar o cliente" + ex);
        }
    }

    public ArrayList<Cliente> ListarClientes() {
        String sql = "SELECT * FROM cliente ORDER BY clinome";
        this.Clientes = new ArrayList<Cliente>();

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setCPF(rs.getString(3));
                cliente.setTelefone(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setCEP(rs.getString(6));
                cliente.setLogradouro(rs.getString(7));
                cliente.setNumero(rs.getString(8));
                cliente.setComplemento(rs.getString(9));
                cliente.setBairro(rs.getString(10));
                cliente.setCidade(rs.getString(11));
                cliente.setEstado(rs.getString(12));

                this.Clientes.add(cliente);

            }
            pst.close();
            conn.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar clientes" + ex);
        }
        return Clientes;
    }

    public boolean AtualizarCliente(int index, Cliente cliente) {
        String sql = "UPDATE cliente SET clinome=?, clicpf=?, clitelefone=?, cliemail=?, clicep=?, "
                + "clilogadouro=?, clinumero=?, clicomplemento=?, clibairro=?, climunicipio=?, cliestado=? WHERE clicod=?";
        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCPF());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEmail());
            pst.setString(5, cliente.getCEP());
            pst.setString(6, cliente.getLogradouro());
            pst.setString(7, cliente.getNumero());
            pst.setString(8, cliente.getComplemento());
            pst.setString(9, cliente.getBairro());
            pst.setString(10, cliente.getCidade());
            pst.setString(11, cliente.getEstado());
            pst.setInt(12, index);

            pst.execute();
            pst.close();
            conn.close();
            System.out.println("CLIENTE ATUALIZADO CO SUCESSO!");
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO AO ATUALIZAR CLIENTE!");
            throw new RuntimeException("Erro ao atuliazar cliente" + ex);
        }

    }

    public void ExcluirCliente(int index) {
        String slq = "DELETE FROM cliente WHERE clicod=?";

        try {
            conn = ConectionFactory.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(slq);

            pst.setInt(1, index);
            pst.execute();
            pst.close();
            conn.close();
            System.out.println("CLIENTE EXCLUIDO COM SUCESSO!");
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXCLUIR CLIENTE:" + ex);
        }
    }

}
