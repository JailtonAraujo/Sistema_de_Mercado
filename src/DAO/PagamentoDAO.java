/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Cliente;
import MODEL.Pagamento;
import MODEL.Usuario;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jailton
 */
public class PagamentoDAO {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Pagamento> ListaDePagamentos;

    public boolean SalvarPagamento(Pagamento pagamento) {
        String sql = "INSERT INTO pagamentos(clicod, usucod, datapagamento, valorpagamento) VALUES (?, ?, ?, ?)";

        try {
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, pagamento.getCliente().getID());
            pst.setInt(2, pagamento.getUsuario().getId());
            pst.setString(3, pagamento.getDataPagemento());
            pst.setFloat(4, pagamento.getValorPagamento());

            pst.execute();
            pst.close();
            conn.close();

            return true;
        } catch (SQLException ex) {
            throw new RuntimeException("ERRO AO SALVAR PAGAMENTO" + ex);
        }
    }

    public ArrayList<Pagamento> ListarPagamentos(int index) {
        String sql = "SELECT \n"
                + "cliente.clinome,\n"
                + "usuario.usunome,\n"
                + "pagamentos.datapagamento,\n"
                + "pagamentos.valorpagamento\n"
                + "FROM\n"
                + "cliente cliente INNER JOIN pagamentos pagamentos ON cliente.clicod = pagamentos.clicod\n"
                + "INNER JOIN usuario usuario ON usuario.usucodigo = pagamentos.usucod\n"
                + "WHERE pagamentos.clicod = ?";
        this.ListaDePagamentos = new ArrayList<Pagamento>();

        try {
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, index);
            rs = pst.executeQuery();

            while (rs.next()) {
                Pagamento pagamento = new Pagamento();

                pagamento.setCliente (new Cliente(rs.getString(1)));
                pagamento.setUsuario(new Usuario(rs.getString(2)));
                pagamento.setDataPagamento(rs.getString(3));
                pagamento.setValorPagamento(rs.getFloat(4));

                this.ListaDePagamentos.add(pagamento);
            }

            conn.close();
            pst.close();
            rs.close();

            return this.ListaDePagamentos;
        } catch (SQLException ex) {
            throw new RuntimeException("ERRO AO LISTAR PAGAMENTOS: " + ex);

        }

    }
}
