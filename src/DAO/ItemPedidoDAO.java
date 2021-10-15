/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.ItenPedido;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jailton
 */
public class ItemPedidoDAO {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean AdicionatItemPedido(ItenPedido item) {
        String sql = "INSERT INTO pedido_item (pedcod, procod, pedproquantidade) VALUES (?, ?, ?)";

        try {
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, item.getPedido().getCodigo());
            pst.setString(2, item.getProduto().getID());
            pst.setInt(3, item.getQuantidade());
            pst.execute();

            pst.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao adinionar item:" + ex);

        }

    }

}
