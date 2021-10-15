/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Produto;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jailton
 */
public class ProdutoDAO {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Produto> Produtos;

    public boolean CadastrarProduto(Produto produto) {
        String sql = "INSERT INTO produto (forcod, pronome, prodescricao, prounidademedida, provalorunitario, procodigo) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, produto.getFornecedor().getID());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getDescricao());
            pst.setString(4, produto.getUnidademedida());
            pst.setFloat(5, produto.getValorunitario());
            pst.setString(6, produto.getID());

            pst.execute();
            pst.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao cadastrar produto" + ex);
        }

    }

    public ArrayList<Produto> ListarProdutos() {
        String sql = "select a. *, b.fornome from produto a join fornecedor b on b.forcodigo = a.forcod ORDER BY pronome";
        this.Produtos = new ArrayList<Produto>();

        try {
            conn = ConectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setID(rs.getString(1));
                produto.setFornecedor(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setUnidademedida(rs.getString(5));
                produto.setValorunitario(rs.getFloat(6));
                produto.setNomeFornecedor(rs.getString(7));

                this.Produtos.add(produto);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("ERRO AO LISTA PRODUTOS:" + ex);
        }
        return Produtos;
    }
    
    public boolean AtualizarProduto(Produto produto){
        String sql = "UPDATE produto SET forcod=?, pronome=?, prodescricao=?, prounidademedida=?, provalorunitario=? WHERE procodigo = ?";
        
        try{
           conn = ConectionFactory.getConnection();
           pst = conn.prepareStatement(sql);
           
           pst.setInt(1, produto.getFornecedor().getID());
           pst.setString(2, produto.getNome());
           pst.setString(3, produto.getDescricao());
           pst.setString(4, produto.getUnidademedida());
           pst.setFloat(5, produto.getValorunitario());
           pst.setString(6, produto.getID());
           
           pst.execute();
           pst.close();
           conn.close();
           
           return true;
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao atualizar produto:"+ex);
        }
    }
    
    public void ExcluirProduto(String procod){
        String sql = "DELETE FROM produto WHERE procodigo = ?";
        
        try{
            conn = ConectionFactory.getConnection();
            pst = conn. prepareStatement(sql);
            
            pst.setString(1, procod);
            pst.execute();
            
            pst.close();
            conn.close();
            System.out.println("PRODUTO EXCLUIDO COM SUCESSO!");
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao excluir produto:" + ex);
        }
        
    }

}
