/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.ItenPedido;
import MODEL.Pedido;
import MODEL.Produto;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jailton
 */
public class PedidoDAO {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Pedido> Pedidos = null;
    ArrayList<Produto> Pedido_Produto = null;
    ArrayList<ItenPedido> Pedido_Iten = null;

    public int AdicionarPedido(Pedido pedido) {
        String slq = "INSERT INTO pedido (peddata, clicod, usucodigo, ped_valor_total, forma_de_pagamento) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, pedido.getData());
            pst.setInt(2, pedido.getCliente().getID());
            pst.setInt(3, pedido.getUsuario().getId());
            pst.setFloat(4, pedido.getValor_total());
            pst.setString(5, pedido.getFormaDePagamento());
            pst.execute();

            rs = pst.getGeneratedKeys();
            rs.next();
            int IdGerado = rs.getInt(1);
            pst.close();
            conn.close();

            return IdGerado;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao adicionar pedido:" + ex);
        }

    }

    public Produto BuscarProduto(String procod) {
        String sql = "SELECT procodigo, pronome, provalorunitario FROM produto WHERE procodigo like'%" + procod + "%'  ";
        Produto produto;

        try {
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            rs.next();
            produto = new Produto();
            produto.setID(rs.getString(1));
            produto.setNome(rs.getString(2));
            produto.setValorunitario(rs.getFloat(3));

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar produto" + ex);
        }

        return produto;
    }

    public ArrayList<Pedido> Listar() {
        String sql = "select  a.pedcod, a.peddata, b.clinome, c.usunome, a.ped_valor_total, a.forma_de_pagamento from "
                + "pedido a join cliente b on b.clicod = a.clicod join usuario c on c.usucodigo = a.usucodigo order by a.peddata desc";
        this.Pedidos = new ArrayList<Pedido>();
        try {
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                
                pedido.setCodigo(rs.getInt(1));
                pedido.setData(rs.getString(2));
                pedido.setNomeCliente(rs.getString(3));
                pedido.setNomeUsuario(rs.getString(4));
                pedido.setValor_total(rs.getFloat(5));
                pedido.setFormaDePagamento(rs.getString(6));

                this.Pedidos.add(pedido);
            }
            conn.close();
            pst.close();
            rs.close();
            

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return Pedidos;
    }
    
    public ArrayList<Produto> RetornaPedidoPorduto(int Id){
        String sql = "SELECT c. * FROM produto c JOIN pedido_item b ON c.procodigo = b.procod JOIN pedido a ON b.pedcod = a.pedcod "
                + "WHERE a.pedcod = ?";
        this.Pedido_Produto = new ArrayList<Produto>();
        
        try{
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setID(rs.getString(1));
                produto.setFornecedor(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setUnidademedida(rs.getString(5));
                produto.setValorunitario(rs.getFloat(6));
                
                this.Pedido_Produto.add(produto);
            }
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao buscar pedido_produto:" +ex);
        }
        return Pedido_Produto;
        
    }
    
    public ArrayList<ItenPedido> RetornaPedido_Item(int Id){
        String sql = "select b. * from pedido_item b JOIN pedido c ON c.pedcod = b.pedcod where c.pedcod = ?";
        this.Pedido_Iten = new ArrayList<ItenPedido>();
        
        try{
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Id);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                ItenPedido iten = new ItenPedido();
                
                iten.setPedido(rs.getInt(1));
                iten.setProduto(rs.getString(2));
                iten.setQuantidade(rs.getInt(3));
                
                this.Pedido_Iten.add(iten);
                
                
            }
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao buscar item_pedido:"+ex);
        
        }
        return this.Pedido_Iten;
    
    }
}
